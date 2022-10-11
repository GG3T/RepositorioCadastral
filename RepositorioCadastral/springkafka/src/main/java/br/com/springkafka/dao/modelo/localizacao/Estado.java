package br.com.springkafka.dao.modelo.localizacao;

public class Estado {

    private String uf, nm_estado;

    public Estado(String uf) {
        this.uf = uf;

        if(uf.equals("SP"))
            this.nm_estado = "São Paulo";
        else if (uf.equals("RJ"))
            this.nm_estado = "Rio de Janeiro";
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNm_estado() {
        return nm_estado;
    }

    public void setNm_estado(String nm_estado) {
        this.nm_estado = nm_estado;
    }
}
