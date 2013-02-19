package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String estado;
    private int totalRuas;
    private int totalBairros;
    private int totalEleitores;
    private int totalHabitantes;
    private int totalDeHabitacoes;
    private double areaQuadradaTotal;

    public Cidade() {

    }

    public Cidade(int id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade(String nome, String estado, int totalRuas, int totalBairros, int totalEleitores, int totalHabitantes, int totalDeHabitacoes, double areaQuadradaTotal) {
        this.nome = nome;
        this.estado = estado;
        this.totalRuas = totalRuas;
        this.totalBairros = totalBairros;
        this.totalEleitores = totalEleitores;
        this.totalHabitantes = totalHabitantes;
        this.totalDeHabitacoes = totalDeHabitacoes;
        this.areaQuadradaTotal = areaQuadradaTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotalRuas() {
        return totalRuas;
    }

    public void setTotalRuas(int totalRuas) {
        this.totalRuas = totalRuas;
    }

    public int getTotalBairros() {
        return totalBairros;
    }

    public void setTotalBairros(int totalBairros) {
        this.totalBairros = totalBairros;
    }

    public int getTotalEleitores() {
        return totalEleitores;
    }

    public void setTotalEleitores(int totalEleitores) {
        this.totalEleitores = totalEleitores;
    }

    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public void setTotalHabitantes(int totalHabitantes) {
        this.totalHabitantes = totalHabitantes;
    }

    public int getTotalDeHabitacoes() {
        return totalDeHabitacoes;
    }

    public void setTotalDeHabitacoes(int totalEmEstradas) {
        this.totalDeHabitacoes = totalEmEstradas;
    }

    public double getAreaQuadradaTotal() {
        return areaQuadradaTotal;
    }

    public void setAreaQuadradaTotal(double areaQuadradaTotal) {
        this.areaQuadradaTotal = areaQuadradaTotal;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cidade) {
            Cidade cidade = (Cidade) obj;
            return cidade.id == id;
        }

        return false;
    }
}