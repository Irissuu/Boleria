package repository;

import enums.TipoBolo;
import models.Bolos;
import java.util.List;

public interface BolosRepository {
    void adicionar(Bolos bolos);
    List<Bolos> listar();
    Bolos consultarPorCodigo(String codigo);
    void alterar(Bolos bolos);
    void excluir(String codigo);
    void buscarPorSaborComForEach(TipoBolo sabor);
}


