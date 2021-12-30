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
    @Autowired
    private Partidos partido;

    @Test
    public void testeCarregaPartidosPorIdeologia(){
        IdeologiaEnun ideologia = ideologia.CENTRO;

        List<Partidos> partidos = repository.findByIdeologia(ideologia.CENTRO);
        Assert.assertNotNull(partidos);
        Assert.assertEquals(ideologia, partido.getIdeologia());
    }
}
