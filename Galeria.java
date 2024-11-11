import java.io.*; // 📦 Importa classes necessárias para manipulação de arquivos e serialização
import java.util.ArrayList; // 📦 Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.List; // 📦 Importa a interface List para representar listas
import java.util.stream.Collectors; // 📦 Importa Collectors para operações de stream (filtragem, coleta)

public class Galeria { // 🖼️ Classe que representa uma galeria de artes
  private List<Arte> artes; // 🖼️ Lista que armazena as artes na galeria

  // 🖼️ Construtor da classe Galeria, que inicializa a lista de artes e carrega as artes do arquivo
  public Galeria() {
    this.artes = new ArrayList<Arte>(); // 📝 Inicializa a lista de artes
    inicializarArtes(); // 🎨 Inicializa artes de exemplo
    artes.addAll(carregarArtesDeArquivo("galeria.ser")); // 🗂️ Carrega as artes do arquivo .ser
  }

  // 🖼️ Método para adicionar uma nova arte à galeria
  public void adicionarArte(Arte arte) {
    if (arte != null && !artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e não está duplicada
      artes.add(arte); // ➕ Adiciona a arte à lista
    } else {
      System.out.println("Arte inválida ou já existente."); // ❌ Informa que a arte é inválida ou já existe
    }
  }

  // 🖼️ Método para obter todas as artes da galeria
  public List<Arte> getArtes() {
    return artes; // 🔄 Retorna a lista de artes
  }

  // 🎨 Método para filtrar as artes pela categoria
  public List<Arte> getArtesPorCategoria(String categoria) {
    return artes.stream() // 🎯 Inicia o fluxo de artes
      .filter(arte -> arte.getCategoria().equalsIgnoreCase(categoria)) // 🔍 Filtra pela categoria
      .collect(Collectors.toList()); // 📝 Coleta as artes filtradas em uma lista
  }

  // 🗑️ Método para remover uma arte da galeria
  public void removerArte(Arte arte) {
    if (arte != null && artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e está na galeria
      artes.remove(arte); // ➖ Remove a arte da lista
    } else {
      System.out.println("Arte não encontrada."); // ❌ Informa que a arte não foi encontrada
    }
  }

  // 🖼️ Método privado que inicializa a galeria com algumas artes de exemplo
  private void inicializarArtes() {
    // 🎨 Exemplo de artes a serem adicionadas à galeria
    adicionarArte(new Arte("Catedral de Notre-Dame de Reims, França", "Eugène Viollet-le-Duc", "Dedicada à Virgem Maria, a Catedral de Notre Dame é uma das catedrais góticas mais antigas do mundo", "src/main/java/recursos/gotico_imagens/acapa-1.png", "Gótica"));
    adicionarArte(new Arte("F. Champenois Imprimeur-Éditeur", "Alfons Mucha", "“Champenois” é uma das obras mais conhecidas do artista tcheco Alphonse Mucha, um dos principais representantes do movimento Art Nouveau. Mucha era conhecido por suas pinturas, cartazes e ilustrações que celebravam a beleza feminina, o esplendor da natureza e a estética ornamental.", "src/main/java/recursos/nouveau_imagens/artnouveau-capa.png", "Nouveau"));
  }

  // 🗂️ Método para carregar as artes a partir de um arquivo
  private List<Arte> carregarArtesDeArquivo(String caminhoArquivo) {
    List<Arte> artes = new ArrayList<>(); // 📝 Cria uma lista vazia de artes
    File arquivo = new File(caminhoArquivo); // 📁 Cria o objeto File para o arquivo

    // Verifica se o arquivo existe e não está vazio
    if (!arquivo.exists() || arquivo.length() == 0) {
      System.out.println("Arquivo vazio ou inexistente."); // ⚠️ Informa que o arquivo não existe ou está vazio
      return artes;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) { // 🗄️ Tenta ler o arquivo com ObjectInputStream
      Object obj = ois.readObject(); // 🔄 Lê o objeto do arquivo

      // Verifica se o objeto lido é uma instância de List
      if (obj instanceof List<?>) { // 📝 Verifica se o objeto é uma lista
        List<?> tempList = (List<?>) obj; // 📝 Faz o cast do objeto para List

        // Verifica se todos os elementos da lista são do tipo Arte
        if (!tempList.isEmpty() && tempList.stream().allMatch(element -> element instanceof Arte)) { // ✔️ Verifica se todos os elementos são do tipo Arte
          artes = tempList.stream() // 🎯 Cria um stream para processar os elementos
                  .map(element -> (Arte) element) // 🔄 Converte os elementos para o tipo Arte
                  .collect(Collectors.toList()); // 📝 Coleta os elementos convertidos em uma lista
          System.out.println("Artes carregadas com sucesso."); // 🎉 Informa que as artes foram carregadas com sucesso
        } 
      } else {
        System.out.println("Erro: O arquivo não contém uma lista válida."); // ❌ Informa que o arquivo não contém uma lista válida
      }
    } catch (IOException | ClassNotFoundException e) { // ⚠️ Trata exceções de IO e Classe não encontrada
      System.out.println("Erro ao carregar artes do arquivo: " + e.getMessage()); // ❌ Informa o erro
      e.printStackTrace(); // 📝 Imprime o stack trace do erro
    } catch (ClassCastException e) { // ⚠️ Trata exceções de cast de classe
      System.out.println("Erro ao fazer o cast do objeto para List<Arte>: " + e.getMessage()); // ❌ Informa erro no cast
      e.printStackTrace(); // 📝 Imprime o stack trace do erro
    }
    return artes; // 🔄 Retorna a lista de artes carregadas
  }
}
