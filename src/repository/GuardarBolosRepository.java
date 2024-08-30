package repository;

import models.Bolos;
import enums.TipoBolo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return bolosList.stream()
                .filter(bolo -> bolo.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
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
        bolosList.removeIf(bolo -> bolo.getCodigo().equals(codigo));
    }

    public void buscarPorSaborComForEach(TipoBolo sabor) {
        bolosList.stream()
                .filter(bolo -> bolo.getSabor() == sabor) // Usando filter
                .forEach(bolo -> {
                    bolo.exibirFichaTecnica();
                    System.out.println();
                });
    }

    public List<Bolos> buscarSaborCollect(TipoBolo sabor) {
        return bolosList.stream()
                .filter(bolo -> bolo.getSabor() == sabor) // Usando filter
                .collect(Collectors.toList()); // Usando collect
    }

    public List<Bolos> consultarBolosListas(List<Bolos> outraLista) {
        return bolosList.stream()
                .filter(outraLista::contains) // Usando filter
                .collect(Collectors.toList()); // Usando collect
    }
}