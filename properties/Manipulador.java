package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Essa classe tem a função de ler os arquivos .properties e retornar os atributos contidos neles
 */
public class Manipulador {
    private String nome;
    private String preco;
    private String aluguel;
    private String caminho;
    private String tamanho;
    private String[] casa;

    /**
     * Construtor que seta o caminho do arquivo .properties
     *
     * @param caminho caminho do arquivo .properties
     */
    public Manipulador(String caminho) {
        this.caminho = caminho;
    }

    /**
     * Seta os atributos do .properties nas suas devidas variáveis
     *
     * @param code identificador do atributo
     * @throws IOException
     */
    public void setandoAtributos(int code) throws IOException {
        Properties props = getProp();
        setNome(code, props);
        setPreco(code, props);
        setAluguel(code, props);
        setCasa(code, props);
    }

    /**
     * Lê o arquivo .properties e o coloca dentro de um objeto Properties
     *
     * @return prop o arquivo .properties em um objeto Properties
     * @throws IOException
     */
    public Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream files = new FileInputStream(this.caminho);
        prop.load(files);

        return prop;
    }

    public void setNome(int code, Properties props) {
        String key = "prop" + code;
        this.nome = props.getProperty(key);
    }

    public void setPreco(int code, Properties props) {
        String key = "preco" + code;
        this.preco = props.getProperty(key);
    }

    public void setAluguel(int code, Properties props) {
        String key = "aluguel" + code;
        this.aluguel = props.getProperty(key);
    }

    public String getTamanho() throws IOException {
        Properties props = getProp();
        this.tamanho = props.getProperty("tamanho");

        return this.tamanho;
    }

    public void setCasa(int code, Properties props) {
        String key = "casa" + code;
        String casas = props.getProperty(key);
        this.casa = casas.split(" ");

    }

    public int getValorCasa1() {
        return Integer.parseInt(this.casa[0]);
    }

    public int getValorCasa2() {
        return Integer.parseInt(this.casa[1]);
    }

    public int getValorCasa3() {
        return Integer.parseInt(this.casa[2]);
    }

    public int getValorCasa4() {
        return Integer.parseInt(this.casa[3]);
    }

    public int getValorHotel() {
        return Integer.parseInt(this.casa[4]);
    }

    public int getValorHipoteca() {
        return Integer.parseInt(this.casa[5]);
    }

    public int getValorDaCasa() {
        return Integer.parseInt(this.casa[6]);
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public String getAluguel() {
        return aluguel;
    }

}
