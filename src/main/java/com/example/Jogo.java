package com.example;

public class Jogo {
    
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo(){
        monte.embaralhar();
    }
    public Carta distribuirCartaParaJogador(Jogador jogador){
        //early return
        if(jogador.parou()) return null;
        
        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }
    public boolean acabou(){
        // os dois pararam
        // o jogador estorou
        // o computador estorou

        var osDoisPararam = jogador.parou() && computador.parou();
        
        
        return osDoisPararam || jogador.estourou() || computador.estourou();
          
    }
    public String resultado(){
        var pontuacaoIgual = jogador.getPontos() == computador.getPontos();
        var osDoisEstouraram = jogador.estourou() && computador.estourou();
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();
 
        if (pontuacaoIgual || osDoisEstouraram) return "Empatou";
 
        if (!jogador.estourou() && (jogadorTemMaisPontos || computador.estourou())) return "Você Ganhou!";
 
        return "Você Perdeu!";
 
    }

    


}
