package br.com.bossini.desviando_de_obstaculos.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import br.com.bossini.desviando_de_obstaculos.config.JogoConfig;
import br.com.bossini.desviando_de_obstaculos.entidade.Personagem;
import br.com.bossini.desviando_de_obstaculos.utils.Utils;

public class JogoTela implements Screen {
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;
    private Personagem personagem;
    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(JogoConfig.WORLD_WIDTH, JogoConfig.WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        personagem = new Personagem();
        //centralizado horizontalmente
        float xInicialDoPersonagem = JogoConfig.WORLD_WIDTH / 2;
        //deslocado para cima de uma unidade de mundo
        float yInicialDoPersonagem = 1;
        personagem.setPosicao(xInicialDoPersonagem, yInicialDoPersonagem);
    }
    @Override
    public void hide() {
        dispose();
    }

    private void atualizarPersonagem(){
        personagem.update();
        //criar getters na classe Personagem
        Gdx.app.debug("X: ", Float.toString(personagem.getX()));
        Gdx.app.debug("Y: ", Float.toString(personagem.getY()));
    }

    private void atualizarMundo (float delta){
        atualizarPersonagem();
    }

    @Override
    public void render(float delta) {
        atualizarMundo(delta);
        Utils.limparTela();
        desenharPersonagem();
        Utils.desenharGrid(this.viewport, this.shapeRenderer);
    }
    private void desenharPersonagem(){
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        personagem.desenhar(shapeRenderer);
        shapeRenderer.end();
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        Utils.exibirPixelsPorUnidadeDeMundo(this.viewport);
    }
    @Override
    public void resume() {
    }
    @Override
    public void pause() {
    }
    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
