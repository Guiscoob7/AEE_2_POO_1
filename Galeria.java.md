```java
import java.io.*; // 📦 Importa classes necessárias para manipulação de arquivos e serialização
import java.util.ArrayList; // 📦 Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.List; // 📦 Importa a interface List para representar listas
import java.util.stream.Collectors; // 📦 Importa Collectors para operações de stream (filtragem, coleta)
```

Aqui, importamos classes essenciais para operações de entrada e saída de arquivos (`ObjectInputStream` e `FileInputStream`), além de listas dinâmicas e streams para manipulação eficiente de dados.

---

### Declaração da Classe `Galeria`

```java
public class Galeria { // 🖼️ Classe que representa uma galeria de artes
  private List<Arte> artes; // 🖼️ Lista que armazena as artes na galeria
```

A classe `Galeria` armazena uma coleção de objetos `Arte`, permitindo adicionar, remover e carregar dados de artes, e realiza operações específicas sobre elas.

---

### Construtor da Classe `Galeria`

```java
  // 🖼️ Construtor da classe Galeria, que inicializa a lista de artes e carrega as artes do arquivo
  public Galeria() {
    this.artes = new ArrayList<Arte>(); // 📝 Inicializa a lista de artes
    inicializarArtes();
    artes.addAll(carregarArtesDeArquivo("galeria.ser")); // 🗂️ Carrega as artes do arquivo .ser
  }
```

No construtor, inicializamos a lista de `Arte` e chamamos `inicializarArtes`, que carrega artes de exemplo, seguido por `carregarArtesDeArquivo`, que tenta carregar dados de um arquivo serializado para recuperar artes salvas.

---

### Método para Adicionar Arte

```java
  // 🖼️ Método para adicionar uma nova arte à galeria
  public void adicionarArte(Arte arte) {
    if (arte != null && !artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e não está duplicada
      artes.add(arte); // ➕ Adiciona a arte à lista
    } else {
      System.out.println("Arte inválida ou já existente."); // ❌ Informa que a arte é inválida ou já existe
    }
  }
```

`adicionarArte` recebe um objeto `Arte` e o adiciona à lista se ele não for nulo ou duplicado, exibindo uma mensagem se a adição falhar.

---

### Método para Obter Todas as Artes

```java
  // 🖼️ Método para obter todas as artes da galeria
  public List<Arte> getArtes() {
    return artes; // 🔄 Retorna a lista de artes
  }
```

Esse método retorna a lista completa de artes na galeria, permitindo acesso externo à coleção completa de `Arte`.

---

### Filtragem por Categoria

```java
  // 🎨 Método para filtrar as artes pela categoria
  public List<Arte> getArtesPorCategoria(String categoria) {
    return artes.stream() // 🎯 Inicia o fluxo de artes
      .filter(arte -> arte.getCategoria().equalsIgnoreCase(categoria)) // 🔍 Filtra pela categoria
      .collect(Collectors.toList()); // 📝 Coleta as artes filtradas em uma lista
  }
```

Aqui usamos o método `getArtesPorCategoria` para retornar uma lista de artes filtrada por categoria, ignorando diferenças de maiúsculas e minúsculas.

---

### Método para Remover Arte

```java
  // 🗑️ Método para remover uma arte da galeria
  public void removerArte(Arte arte) {
    if (arte != null && artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e está na galeria
      artes.remove(arte); // ➖ Remove a arte da lista
    } else {
      System.out.println("Arte não encontrada."); // ❌ Informa que a arte não foi encontrada
    }
  }
```

O método `removerArte` verifica a presença da arte na lista e a remove caso ela exista, informando se não for encontrada.

---

### Método Privado para Inicializar Artes de Exemplo

```java
  // 🖼️ Método privado que inicializa a galeria com algumas artes de exemplo
  private void inicializarArtes() {
    // 🎨 Exemplo de artes a serem adicionadas à galeria
    adicionarArte(new Arte("Catedral de Notre-Dame de Reims, França", "Eugène Viollet-le-Duc", "Dedicada à Virgem Maria, a Catedral de Notre Dame é uma das catedrais góticas mais antigas do mundo", "src/main/java/recursos/gotico_imagens/acapa-1.png", "Gótica"));
    adicionarArte(new Arte("F. Champenois Imprimeur-Éditeur", "Alfons Mucha", "“Champenois” é uma das obras mais conhecidas do artista tcheco Alphonse Mucha, um dos principais representantes do movimento Art Nouveau. Mucha era conhecido por suas pinturas, cartazes e ilustrações que celebravam a beleza feminina, o esplendor da natureza e a estética ornamental.", "src/main/java/recursos/nouveau_imagens/artnouveau-capa.png", "Nouveau"));
  }
```

Esse método privado adiciona obras de exemplo à galeria, ideal para iniciar com uma coleção padrão.

---

### Método para Carregar Artes do Arquivo

```java
  private List<Arte> carregarArtesDeArquivo(String caminhoArquivo) {
    List<Arte> artes = new ArrayList<>();
    File arquivo = new File(caminhoArquivo);

    // Verifica se o arquivo existe e não está vazio
    if (!arquivo.exists() || arquivo.length() == 0) {
      System.out.println("Arquivo vazio ou inexistente.");
      return artes;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
      Object obj = ois.readObject();

      // Verifica se o objeto lido é uma instância de List
      if (obj instanceof List<?>) {
        List<?> tempList = (List<?>) obj;

        // Verifica se todos os elementos da lista são do tipo Arte
        if (!tempList.isEmpty() && tempList.stream().allMatch(element -> element instanceof Arte)) {
          artes = tempList.stream()
                  .map(element -> (Arte) element)
                  .collect(Collectors.toList());
          System.out.println("Artes carregadas com sucesso.");
        } 
      } else {
        System.out.println("Erro: O arquivo não contém uma lista válida.");
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Erro ao carregar artes do arquivo: " + e.getMessage());
      e.printStackTrace();
    } catch (ClassCastException e) {
      System.out.println("Erro ao fazer o cast do objeto para List<Arte>: " + e.getMessage());
      e.printStackTrace();
    }
    return artes;
  }
```

Esse método lê as artes de um arquivo `.ser` e valida seu conteúdo, verificando se é uma lista válida de objetos `Arte`, e lida com exceções de E/S e classes não encontradas. Ele exibe mensagens informativas em caso de erro.

---

Esta implementação da `Galeria` oferece funcionalidades completas para gerenciar, carregar e armazenar artes de uma coleção, mantendo um fluxo de dados robusto e eficiente.
