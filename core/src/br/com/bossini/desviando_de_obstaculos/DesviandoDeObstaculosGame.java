package br.com.bossini.desviando_de_obstaculos;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import br.com.bossini.desviando_de_obstaculos.tela.JogoTela;
public class DesviandoDeObstaculosGame extends Game {
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new JogoTela());
	}
}
