package com.Sprint4.avaliacao;

import com.Sprint4.avaliacao.partidos.IdeologiaEnun;
import com.Sprint4.avaliacao.partidos.Partidos;
import com.Sprint4.avaliacao.repository.PartidosRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PartidosRepositoryTest {

    @Autowired
    private PartidosRepository repository;


    @Test
    public void testeCarregaPartidosPorIdeologia(){
        Partidos partidos = new Partidos();
        partidos.setIdeologia(IdeologiaEnun.CENTRO);

        List<Partidos> teste = repository.findByIdeologia(partidos.getIdeologia());
        Assert.assertNotNull(teste);
        Assert.assertEquals(teste, repository.findByIdeologia(IdeologiaEnun.CENTRO));
    }
}
