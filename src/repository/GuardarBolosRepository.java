package repository;

import models.Bolos;
import java.util.ArrayList;
import java.util.List;

public class GuardarBolosRepository implements BolosRepository {
    private List<Bolos> bolosList = new ArrayList<>();

    @Override
    public void adicionar(Bolos bolo) {
        bolosList.add(bolo);
    }

    @Override
    public List<Bolos> listar() {
        return new ArrayList<>(bolosList);
    }

    @Override
    public Bolos consultarPorCodigo(String codigo) {
        for (Bolos bolo : bolosList) {
            if (bolo.getCodigo().equals(String.valueOf(codigo))) {
                return bolo;
            }
        }
        return null;
    }

    @Override
    public void alterar(Bolos bolo) {
        for (int i = 0; i < bolosList.size(); i++) {
            if (bolosList.get(i).getCodigo().equals(bolo.getCodigo())) {
                bolosList.set(i, bolo);
                return;
            }
        }
    }

    @Override
    public void excluir(String codigo) {
        bolosList.removeIf(bolo -> bolo.getCodigo().equals(String.valueOf(codigo)));
    }
}