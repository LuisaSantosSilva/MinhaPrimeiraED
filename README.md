# Minha Primeira Estrutura de Dados - ADS


Dada a classe abaixo, implementar as seguintes operações:


public class MinhaPrimeiraED {

  private Object[] objetos = new Object[10];

  public int totalDeObjetos = 0;

 

  public void adiciona(int posicao, Object objeto){..}

  public void adiciona(Object objeto){..}

  private boolean posicaoOcupada(int posicao){..}

  private boolean posicaoValida(int posicao){..}

  public void remove(int posicao){..}

  public boolean contem(Object objeto){..}

  public Object getObjeto(int posicao){...}

  public int tamanho(){..}

}

##
 

Considere que as operações deve preservar os objetos na sequência dos índices, não sendo permitido pular posições do vetor.

- A operação public void adiciona(int posicao, Object objeto){..} deve adicionar um objeto numa determinada posição do vetor. Caso a posição esteja ocupada, deslocar os elementos uma posição à direita para não sobrepor o novo objeto.
- A operação public void adiciona(Object objeto){..} deve adicionar elementos no vetor respeitando a ordem do índice. Caso não haja mais posições válidas, não adicionar.
- A operação private boolean posicaoOcupada(int posicao){..} deve verificar se a posição está ou não ocupada. Retornar True para ocupada e False para livre.
- A operação private boolean posicaoValida(int posicao){..}, deve retornar True se a posição for válida. Uma posição é válida se estiver entre os índices 0 e a última posição ocupada do vetor.  
- A operação public void remove(int posicao){..} deve remover o elemento de uma determinada posição do vetor. No entanto, como a sequência dos índices não poderá ser pulada, se houver elementos nas posições a direita do vetor, você deverá deslocar todos os elementos para uma posição anterior. 
- A operação public boolean contem(Object objeto){..} deve retornar True se o objeto pesquisado for encontrado no vetor. Implemente uma pesquisa linear conforme vimos em classe. 
- A operação public Object getObjeto(int posicao){...} deve retornar o objeto de uma determinada posição.
- A operação public int tamanho(){..} deve retornar quantos elementos existem no vetor.
- Implemente uma operação que verifique se o vetor está cheio. O vetor estará cheio quando o total de objetos é igual ao tamanho do vetor. Sempre que o vetor estiver cheio, criar um novo vetor cujo tamanho deve ser o dobro do anterior, copiar os elementos para o novo vetor. Com esta operação, as operações adiciona sempre vão funcionar.
