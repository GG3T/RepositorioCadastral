package br.com.springkafka.dao.modelo.localizacao;

public class Cidade extends Estado{

    private int id_cidade;
    private String nm_cidade;

    public Cidade(String uf, int id_cidade) {
        super(uf);
        this.id_cidade = id_cidade;

        if(id_cidade == 0)
            this.nm_cidade = "São Paulo";
        else if (id_cidade == 1)
            this.nm_cidade = "Rio de Janeiro";
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNm_cidade() {
        return nm_cidade;
    }

    public void setNm_cidade(String nm_cidade) {
        this.nm_cidade = nm_cidade;
    }
}
