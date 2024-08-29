package repository;

import models.Bolos;
import java.util.List;

public interface BolosRepository {

    public void adicionar(Bolos bolos);
    List<Bolos> listar();
    Bolos consultarPorCodigo(String codigo);
    void alterar(Bolos bolos);
    void excluir(String codigo);
}
