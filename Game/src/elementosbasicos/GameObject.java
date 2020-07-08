package elementosbasicos;

import java.util.ArrayList;
import Usaveis.*;
import Externos.*;

public abstract class GameObject extends Objeto {
	private final int hpcheio;
	private int hp;
	private int ip;
	private int dadosAtq;
	private int dadosDfs;
<<<<<<< HEAD
	private Armadura armadura;
	
	//Posição no mapa que será configurado posteriormente
	//private Posic pos;
	
	//arma
=======

	// Posição no mapa que será configurado posteriormente
	// private Posic pos;

	// arma
>>>>>>> branch 'master' of https://github.com/Pedro-Andrade-POSDR/MC322HeroQuest.git
	private Arma armaD;
	private Arma armaE;
<<<<<<< HEAD
	//Lista de itens
	private ListaItens itens;
	//Lista de magias
	private ListaItens magias;
	
	
	
=======
	// Lista de itens
	private ArrayList<Item> itens;
	// Lista de magias
	private ArrayList<Magia> magias;

>>>>>>> branch 'master' of https://github.com/Pedro-Andrade-POSDR/MC322HeroQuest.git
	public GameObject(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y);
		this.hpcheio = hp;
		this.hp = hp;
		this.ip = ip;
		this.dadosAtq = atq;
		this.dadosDfs = dfs;
		this.itens = new ListaItens();
		this.magias = new ListaItens();
		this.armadura.setValor_armadura(0);
	}

	protected void equipar(boolean mao, Arma arma) {// true esquerda false direita
		if (mao) {
			armaE = arma;
		} else {
			armaD = arma;
		}
	}

	protected void destruirArma(Arma arma) { // destrói armas destrutíveis transformando em null
		if (arma.getDestrutivel()) {
			if (arma.equals(armaD)) {
				armaD = null;
			} else if (arma.equals(armaE)) {
				armaE = null;
			}
		}

	}

	protected boolean isAlive() {
		if (hp <= 0)
			return false;
		return true;

	}

	public int getDefesa() {
		return dadosDfs;
	}

	// Se escolhe qual direção cardinal se atacará

	protected void Atacar(String direcao) {
		GameObject inimigo = InimigoAlcancavel(direcao); // Função será criada posteriormente e devolve o inimigo no
															// alcance, ou devolve null

		if (inimigo == null)
			return;

		int numeroDados = dadosAtq;// + armaD.getDano + armaE.getDano;
		int dadoAliado = 0;
		int aux;

		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if (0 < aux && aux < 4)
				dadoAliado += 1;
		}

		int dadoInimigo = inimigo.Defender(); // Função será criada posteriormente e devolve o número de escudos

		int resultado = dadoAliado - dadoInimigo;

		if (resultado > 0)
			inimigo.receberDano(resultado);
	}

	protected abstract int Defender();

	protected abstract void Andar();

	public void receberDano(int dano) {
		hp -= dano;
	}

	public void receberCura(int cura) {
		if (hp + cura > hpcheio)
			hp = hpcheio;
		else
			hp += cura;

	}
<<<<<<< HEAD
	
	protected int usarArmadura(int ataque) {
		int ataque_final;
		ataque_final = ataque - armadura.getValor_armadura();
		return ataque_final;
	}
	
	protected void lancaMagia(int posic) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria todas com números e ele escolheria a que ele quer lançar
=======

	protected void lancaMagia(int posic) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria
											// todas com números e ele escolheria a que ele quer lançar
>>>>>>> branch 'master' of https://github.com/Pedro-Andrade-POSDR/MC322HeroQuest.git
		int dado = Dados.resultadoDado(TipoDado.COMUM);
		if (dado < ip) {
			System.out.println("Magia fracassou");
			return;
		}

		Magia magia = magias.get(posic - 1);

		magia.Usar();
	}

	protected void usarItem(int posic) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria todas
											// com números e ele escolheria a que ele quer lançar
		Item item = itens.get(posic - 1);

		item.Usar();
	}

}
