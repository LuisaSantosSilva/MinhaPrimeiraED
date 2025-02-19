//Luisa Santos Silva - Estrutura de Dados

/*
 * Obs:
 * Os comentários foram feitos como forma de organização e entendimento da lógica 
 * uilizada no momento do desenvolvimento do exercício, o que facilita estudos e entendimentos futuros
 */

//Classe MinhaPrimeiraED
public class MinhaPrimeiraED {

    // Definindo tamanho inicial do vetor e seu tipo Object
    private Object[] objetos = new Object[10];
    // Definindo Variável que irá receber o total de objetos dentro do vetor
    public int totalDeObjetos = 0;

    /*
     * Instrução da atividade:
     * A operação public void adiciona(int posicao, Object objeto){..} deve
     * adicionar um objeto numa determinada posição do vetor. Caso a posição esteja
     * ocupada, deslocar os elementos uma posição à direita para não sobrepor o novo
     * objeto.
     */

    public void adiciona(int posicao, Object objeto) {

        // Chama o método 'posicaoValida()' para verificação
        // Caso seja válida, os comandos da operação continuam
        if (posicaoValida(posicao)) {

            // Chama o método 'cheio()' para verificação
            if (cheio()) {
                // O método 'cheio()' já faz o redimensionamento do vetor
            }

            // Caso a posição esteja ocupada
            if (posicaoOcupada(posicao)) {
                // Desloca os elementos uma posição à direita
                for (int i = totalDeObjetos; i > posicao; i--) {
                    objetos[i] = objetos[i - 1];
                }

                // Adiciona o objeto na posição desejada
                objetos[posicao] = objeto;
                totalDeObjetos++;
            }
            // Caso a posição não esteja ocupada
            else {
                // Adiciona o objeto na posição desejada
                objetos[posicao] = objeto;
                totalDeObjetos++;
            }
        }
        // Caso não seja válida, mensagem de erro
        else {
            System.out.println("Posição do vetor inválida");
        }
    }

    /*
     * Instrução da atividade:
     * A operação public void adiciona(Object objeto){..} deve adicionar elementos
     * no vetor respeitando a ordem do índice. Caso não haja mais posições válidas,
     * não adicionar.
     */

    public void adiciona(Object objeto) {

        /*
         * Luisa Santos - Obs/Anotações feitas no desenvolvimento do exercício:
         * Ao pensar na regra de respeitar as ordens dos indices e a regra que é citada
         * na função de remover (sobre que a sequência dos índices não poderá ser
         * pulada), essa operação de adicionar poderia ser feita de duas formas
         * distintas, como pegar o número total de objetos e adicionar, que seria o
         * proximo número do vetor livre, já que o vetor começa com 0 (está
         * exemplificado como 1° Forma) ou como também poderia ser na primeira posição
         * do vetor desocupado ou "nulo" que encontrasse (está exemplificado como 2°
         * forma em comentário).
         */

        // 1° Forma:
        if (!cheio()) {
            objetos[totalDeObjetos] = objeto;
            totalDeObjetos++;
        }

        /*
         * 2° Forma:
         * if (!cheio()) {
         * for (int i = 0; i < objetos.length; i++) {
         * if (objetos[i] == null) {
         * objetos[i] = objeto;
         * totalDeObjetos++;
         * return;
         * }
         * }
         * }
         */

    }

    /*
     * Instrução da atividade:
     * A operação private boolean posicaoOcupada(int posicao){..} deve verificar se
     * a posição está ou não ocupada. Retornar True para ocupada e False para livre.
     */

    private boolean posicaoOcupada(int posicao) {
        // Retorna true se a posição não for null, senão false.
        return objetos[posicao] != null;
    }

    /*
     * Instrução da atividade:
     * A operação private boolean posicaoValida(int posicao){..}, deve retornar True
     * se a posição for válida. Uma posição é válida se estiver entre os índices 0 e
     * a última posição ocupada do vetor.
     */

    private boolean posicaoValida(int posicao) {
        // Retorna true se posicao estiver entre 0 e totalDeObjetos, senão false.
        return posicao >= 0 && posicao <= objetos.length;
    }

    /*
     * Instrução da atividade:
     * A operação public void remove(int posicao){..} deve remover o elemento de uma
     * determinada posição do vetor. No entanto, como a sequência dos índices não
     * poderá ser pulada, se houver elementos nas posições a direita do vetor, você
     * deverá deslocar todos os elementos para uma posição anterior.
     */

    public void remove(int posicao) {

        /*
         * Luisa Santos - Obs/Anotações feitas no desenvolvimento do exercício:
         * Como a sequência de indices não pode ser pulada, ou seja, [1, 2, null, 3,
         * 4...] podemos colocar o "totaldeObjetos" no for como número máximo, já que
         * não há espaços designados vazios no meio do vetor.
         * Mas se tivessemos esses espaços ao invés de colocar o "totalDeObjetos" como
         * valor final, teriamos que colocar "objetos.length" já que o total de objetos
         * iam estar variados entre um e outro fazendo com que o número final tenha que
         * ser em cima do tamanho total do vetor e não do número de objetos para a
         * remoção.
         */

        // Verifica se a posição é valida e se está ocupada
        if (posicaoValida(posicao) && posicaoOcupada(posicao)) {
            // Desloca os elementos subsequentes uma posição para a esquerda
            for (int i = posicao; i < totalDeObjetos - 1; i++) {
                // Substitui o elemento atual pelo próximo
                objetos[i] = objetos[i + 1];
            }

            // Define a última posição como null para evitar referências desnecessárias
            objetos[totalDeObjetos - 1] = null;

            // Atualiza o total de objetos no vetor
            totalDeObjetos--;

        }
        // Se a posição não for válida ou não está ocupada, mensagem de erro
        else {
            System.out.println("Posição do vetor inválida ou não há o que remover nessa posição");
        }
    }

    /*
     * Instrução da atividade:
     * A operação public boolean contem(Object objeto){..} deve retornar True se o
     * objeto pesquisado for encontrado no vetor. Implemente uma pesquisa linear
     * conforme vimos em classe.
     */

    public boolean contem(Object objeto) {
        // Pesquisa linear: percorre o vetor elemento por elemento
        for (int i = 0; i < totalDeObjetos; i++) {
            // Compara o elemento atual com o objeto buscado
            if (objetos[i].equals(objeto)) {
                // Retorna true se o objeto for encontrado
                return true;
            }
        }
        // Retorna false se o objeto não estiver no vetor
        return false;
    }

    /*
     * Instrução da atividade:
     * A operação public Object getObjeto(int posicao){...} deve retornar o objeto
     * de uma determinada posição.
     */

    public Object getObjeto(int posicao) {
        // Verifica se a posição é valida e se está ocupada
        if (posicaoValida(posicao) && posicaoOcupada(posicao)) {
            // se sim retorna objeto da posição da determinada posição
            return objetos[posicao];
        } else {
            // se não apresenta mensagem de erro e returna null
            System.out.println("Posição do vetor inválida ou desocupada");
            return null;
        }

    }

    /*
     * Instrução da atividade:
     * A operação public int tamanho(){..} deve retornar quantos elementos existem
     * no vetor.
     */

    public int tamanho() {

        /*
         * Luisa Santos - Obs/Anotações feitas no desenvolvimento do exercício:
         * Nesse caso, daria para interpretar de duas formas como, os elementos totais
         * ocupados que existem no vetor que poderia ser parametrizado pelo
         * totaldeObjetos ou os elementos totais contando os nulos no
         * vetor ou seja o tamanho a qual o vetor comporta no momento.
         */

        // Para saber os objetos ocupados/armazenados no vetor:
        return totalDeObjetos;

        // Para saber o total de elementos no vetor, incluindo os desocupados:
        // return objetos.length;
    }

    /*
     * Instrução da atividade:
     * Implemente uma operação que verifique se o vetor está cheio. O vetor estará
     * cheio quando o total de objetos é igual ao tamanho do vetor. Sempre que o
     * vetor estiver cheio, criar um novo vetor cujo tamanho deve ser o dobro do
     * anterior, copiar os elementos para o novo vetor. Com esta operação, as
     * operações adiciona sempre vão funcionar.
     */

    public boolean cheio() {

        /*
         * Luisa Santos - Obs/Anotações feitas no desenvolvimento do exercício:
         * Nesse caso, daria para fazer um novo método onde ele poderia se chamar
         * 'redimensionarVetor()' e o método cheio ser só para verificar se o vetor está
         * de fato cheio e caso estiver chamar essa nova função para duplicar seu
         * tamanho, mas decidi deixar somente com as funções pré estabelecidas pela
         * atividade e fazer essa operação diretamente nesse método 'cheio()'
         */

        // Verifica se o vetor está cheio
        if (objetos.length == totalDeObjetos) {
            // Cria um novo vetor com o dobro do tamanho do vetor atual
            Object[] vetorNovo = new Object[objetos.length * 2];

            // Copia todos os elementos do vetor original para o novo vetor
            for (int i = 0; i < objetos.length; i++) {
                vetorNovo[i] = objetos[i];
            }

            // Substitui o vetor original pelo novo vetor maior
            objetos = vetorNovo;

            // Retorna true indicando que o vetor foi redimensionado
            return true;
        }
        // Retorna false se o vetor não está cheio
        return false;
    }

    // Indicado na atividade para detectar vetor vazio
    public boolean vazio() {
        // Retorna true se não houver elementos no vetor, senão false.
        return totalDeObjetos == 0;
    }

    /*
     * Bloco de teste da aplicação
     * - Método Extra 'exibeVetor()' para exibir a exemplificação do vetor completo
     * nos testes
     * - Método principal, para a execução
     */

    public void exibeVetor() {
        System.out.print("Vetor: [");
        // Inicia o loop para percorrer todos os elementos do vetor "objetos"
        for (int i = 0; i < objetos.length; i++) {

            // Verifica se o elemento atual do vetor não é null
            if (objetos[i] != null) {
                // Se não for null, imprime o valor do elemento
                System.out.print(objetos[i]);
            } else {
                // Se for null, imprime a palavra "null"
                System.out.print("null");
            }
            // Se o elemento atual não for o último do vetor, imprime uma vírgula
            if (i < objetos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        // instância da classe MnhaPrimeiraED
        MinhaPrimeiraED minhaEd = new MinhaPrimeiraED();

        // Testando método `vazio()`
        System.out.println("Vetor inicial vazio? " + minhaEd.vazio()); // Esperado: true
        minhaEd.exibeVetor();

        // Testando método `adiciona()' até chegar na última posição válida
        for (int i = 0; i < 10; i++) {
            minhaEd.adiciona("Objeto " + (i + 1));
        }
        System.out.println("Vetor após preencher 10 posições:");
        minhaEd.exibeVetor();

        // Testando método `remove()'
        minhaEd.remove(5);
        System.out.println("Vetor após remover posição 5:'Objeto 6'");
        minhaEd.exibeVetor();

        // Testando método `adiciona()' expecificando posição
        minhaEd.adiciona(5, "Novo Objeto 6");
        System.out.println("Vetor após adicionar novo objeto na posição 5:");
        minhaEd.exibeVetor();

        // Testando método `tamanho()`
        System.out.println("Total de elementos ocupados no vetor: " + minhaEd.tamanho()); // Esperado: 10
        System.out.println();

        // Testando `contem()`
        System.out.println("O vetor contém 'Objeto 1'? " + minhaEd.contem("Objeto 1")); // Esperado: true
        System.out.println("O vetor contém 'Objeto teste'? " + minhaEd.contem("Objeto teste")); // Esperado: false
        System.out.println();

        // Testando `posicaoValida()`
        System.out.println("Posição 5 é válida? " + minhaEd.posicaoValida(5)); // Esperado: true
        System.out.println("Posição 15 é válida? " + minhaEd.posicaoValida(15)); // Esperado: false (fora do vetor)
        System.out.println();

        // Testando se o vetor aumenta ao adicionar um objeto extra
        minhaEd.adiciona(9, "Objeto extra");
        System.out.println(
                "Vetor após adicionar 'Objeto extra' na última posição ocasionando que fique mais de 10 valores:");
        minhaEd.exibeVetor();

        // Testando método `tamanho()`
        System.out.println("Total de elementos ocupados no vetor: " + minhaEd.tamanho()); // Esperado: 11
        System.out.println();

        // Testando `posicaoValida()` (agora com o dobro)
        System.out.println("Posição 15 é válida? " + minhaEd.posicaoValida(15)); // Esperado: true
        System.out.println();
    }

}
