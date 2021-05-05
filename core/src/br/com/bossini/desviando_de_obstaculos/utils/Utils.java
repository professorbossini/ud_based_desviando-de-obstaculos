package br.com.bossini.desviando_de_obstaculos.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Locale;

public class Utils {
    private static final Logger log = new Logger (Utils.class.getName(), Logger.DEBUG);
    //tamanho padrão para as células do grid
    private static final int TAMANHO_PADRAO_CELULA_GRID = 1;
    //grid com células de tamanho padrão
    public static void desenharGrid (Viewport viewport, ShapeRenderer shapeRenderer){
        desenharGrid(viewport, shapeRenderer, TAMANHO_PADRAO_CELULA_GRID);
    }
    //grid com célular de tamanho especificado no parâmetro
    public static void desenharGrid (Viewport viewport, ShapeRenderer shapeRenderer, int tamanhoCelula){
        int worldWidth = (int)viewport.getWorldWidth();
        int worldHeight = (int) viewport.getWorldHeight();
        //informa ao renderer onde se encontra a câmera, sua rotação etc
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        //guardamos a cor original para depois reconfigurá-la
        Color corOriginal = shapeRenderer.getColor().cpy();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //lembre-se que 0,0 é a região central da tela
        //desenhando linhas verticais
        //*2: o grid vai além do viewport, ficará mais claro no futuro
        for (int x = -2 * worldWidth; x < 2 * worldWidth; x+= tamanhoCelula){
            //Gdx.app.debug("X: ", Integer.toString(x));
            shapeRenderer.line(x, -2 * worldHeight,  x, 2* worldHeight);
        }
        //horizontais
        for (int y = -2 * worldHeight;y < 2 * worldHeight; y += tamanhoCelula){
            //Gdx.app.debug("y: ", Integer.toString(y));
            shapeRenderer.line(-2 * worldWidth, y, 2* worldWidth, y );
        }
        //linhas centrais
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.line(0, -2 * worldHeight, 0, 2* worldHeight);
        shapeRenderer.line(-2*worldWidth, 0, 2*worldWidth, 0);
        //extremos do mundo, visíveis depois de um zoom out
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.line(0, worldHeight, worldWidth, worldHeight);
        shapeRenderer.line(worldWidth, 0, worldWidth, worldHeight);

        shapeRenderer.end();
        shapeRenderer.setColor(corOriginal);
    }

    public static void exibirPixelsPorUnidadeDeMundo (Viewport viewport){
        log.debug(String.format(
                //sem Locale é fonte de bugs conhecidos
                Locale.getDefault(),
                "PixelPorUnidadeDeMundo(x): %f, PixelPorUnidadeDeMundo(y): %f",
                viewport.getScreenWidth() / viewport.getWorldWidth(),
                viewport.getScreenHeight() / viewport.getWorldHeight()
        ));
    }

    public static void limparTela() {
        limparTela(Color.BLACK);
    }

    public static void limparTela(Color color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
