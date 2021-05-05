package br.com.bossini.desviando_de_obstaculos.config;

public class JogoConfig {
    //em pixels
    public static final float WIDTH = 480f;
    public static final float HEIGHT = 800f;

    //coordenadas de "mundo"
    public static final float WORLD_WIDTH = 6.0f;
    public static final float WORLD_HEIGHT = 10.0f;

    //ponto central (coordenadas de mundo)
    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f;
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f;

    //não poderá ser instanciada
    private JogoConfig() {
    }
}
