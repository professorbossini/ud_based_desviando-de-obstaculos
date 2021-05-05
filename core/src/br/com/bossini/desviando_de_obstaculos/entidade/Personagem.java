package br.com.bossini.desviando_de_obstaculos.entidade;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Personagem {
    //coordenadas de mundo
    private static final float RAIO_AREA_OCUPADA = 0.4f;
    private static final float TAMANHO = 2 * RAIO_AREA_OCUPADA;
    private static final float VELOCIDADE_X_MAXIMA = 0.25f;
    private float x;
    private float y;
    private Circle areaOcupada;

    public Personagem(){
        areaOcupada = new Circle(x, y, RAIO_AREA_OCUPADA);
    }
    public void setPosicao (float x, float y){
        this.x = x;
        this.y = y;
        areaOcupada.setPosition(x, y);
    }
    public void desenhar (ShapeRenderer renderer){
        //30 segmentos para formar o círculo
        renderer.circle(areaOcupada.x, areaOcupada.y, areaOcupada.radius, 30);
    }

    public void update (){
        float velocidadeX = 0f;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            velocidadeX = VELOCIDADE_X_MAXIMA;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            velocidadeX = -VELOCIDADE_X_MAXIMA;
        }
        //this.x += velocidadeX;
        setPosicao(x + velocidadeX, y);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
