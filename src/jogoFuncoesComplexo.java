import java.util.Scanner;
import java.util.Random;

public class jogoFuncoesComplexo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int pocao = 2;
        int xp = 0;
        boolean especialDisponivel = true;
        boolean defesa = false;
        boolean emBatalha = true;

        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0 && emBatalha) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");

            int escolha = sc.nextInt();

            if (escolha == 1) {
                // TODO: chamar a função atacar()
                // Essa função deve:
                // 1. Gerar um número aleatório entre 8 e 12 para o dano.
                // 2. Ter 20% de chance de ataque crítico (dano dobrado).
                // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
                // 4. Retornar a nova vida do monstro após o ataque.
                vidaMonstro = atacar(vidaMonstro, rand);


            } else if (escolha == 2) {
                // TODO: chamar a função usarPocao()
                // Essa função deve:
                // 1. Verificar se Taffeson ainda tem poções.
                // 2. Se tiver, recuperar 15 de vida.
                // 3. Mostrar mensagens ("Você usou uma poção", "Não há poções restantes").
                // 4. Retornar a nova vida de Taffeson.
                // vidaHeroi = usarPocao(vidaHeroi, pocao);
                // if (pocao > 0) pocao--; // só gasta se tinha

                vidaHeroi = usarPocao(vidaHeroi, pocao);

                if (pocao > 0) {
                    pocao--;
                } else {
                    System.out.println("Não há poções restantes!");
                }

            } else if (escolha == 3) {
                // TODO: chamar a função defender()
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();

                defesa = defender();


            } else if (escolha == 4) {
                // TODO: chamar a função poderEspecial()
                // Essa função deve:
                // 1. Só poder ser usada UMA vez no jogo.
                // 2. Causar 25 de dano fixo no monstro.
                // 3. Mostrar mensagens ("Taffeson usou o poder especial!").
                // if (especialDisponivel) {
                //     vidaMonstro = poderEspecial(vidaMonstro);
                //     especialDisponivel = false;
                // } else {
                //     System.out.println("❌ O poder especial já foi usado!");
                // }

                if (especialDisponivel) {
                    vidaMonstro = poderEspecial(vidaMonstro);
                    especialDisponivel = false;
                } else {
                    System.out.println("❌ O poder especial já foi usado!");
                }

            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                // fugir();

                emBatalha = fugir();
                break;

            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            // Turno do monstro
            //TODO leve essa logica para uma função chamada Ataque de Mostro()

            vidaHeroi = ataqueMonstro(vidaHeroi, rand, defesa);
            defesa = false;
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            // xp = ganharXP();

            xp = ganharXp(rand);


            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else if (!emBatalha){
            System.out.println("Sem herói o vilarejo está em perigo!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }



    public static int atacar(int vidaMonstro, Random rand) {

        int ataqueHeroi = rand.nextInt(4) + 8; // dano entre 8 e 12
        boolean critico = rand.nextInt(100) < 20; // 20% de chance crítico
        if (critico) {
            ataqueHeroi *= 2;
            System.out.println("💥 O Taffeson acertou um CRÍTICO!");
        }
        vidaMonstro -= ataqueHeroi;
        System.out.println("\uD83D\uDDE1 O Tafferson atacou e causou " + ataqueHeroi + " de dano!");

        return vidaMonstro;
    }

    public static int usarPocao(int vidaHeroi, int pocao) {

        if (pocao > 0) {
            vidaHeroi += 15;
            System.out.println("Você usou uma poção e recuperou 15 pontos de vida");
        }

        return vidaHeroi;
    }

    public static boolean defender(){

        System.out.println("Taffeson está defendendo.");
        boolean defender = true;

        return defender;

    }

    public static int poderEspecial(int vidaMonstro) {

        System.out.println("Taffeson usou o Poder Especial!!");
        System.out.println("Taffeson causou 25 de dano!!");
        vidaMonstro -= 25;

        return vidaMonstro;
    }

    public static boolean fugir (){
        System.out.println("Taffeson fugiu da batalha!");
        boolean emBatalha = false;
        return emBatalha;
    }

    public static int ganharXp(Random rand){
        int xp = rand.nextInt(20) + 10;

        return xp;
    }

    public static int ataqueMonstro(int vidaHeroi, Random rand, boolean defesa) {

            int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
            boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
            if (critico) {
                ataqueMonstro *= 2;
                System.out.println("💥 O monstro acertou um CRÍTICO!");
            }
            if (defesa){
                ataqueMonstro /= 2;
                defesa = false;
            }

            vidaHeroi -= ataqueMonstro;
            System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");

            return vidaHeroi;
        }
    }


    // =============================
    // Funções DEVEM implementar, como exemplo
    // =============================

    // public static int atacar(int vidaMonstro, Random rand) { ... }

    // public static void defender() { ... }

    // public static int poderEspecial(int vidaMonstro) { ... }

