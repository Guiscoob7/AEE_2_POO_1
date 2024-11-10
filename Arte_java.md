```markdown
# Classe `Arte` 🎨

A classe `Arte` representa uma obra de arte na galeria, contendo informações como título, artista, descrição, caminho da imagem, categoria e uma lista de comentários sobre a obra.

## Atributos

- `titulo` (String) 🏷️: O título da obra de arte.
- `artista` (String) 👩‍🎨: O nome do artista responsável pela obra.
- `descricao` (String) 📝: Uma descrição detalhada da obra de arte.
- `imagemCaminho` (String) 🖼️: O caminho da imagem que representa a obra de arte.
- `categoria` (String) 📚: A categoria da obra (por exemplo, Gótica, Art Nouveau).
- `comentarios` (List<String>) 💬: Uma lista de comentários feitos sobre a obra.

## Construtor

### `public Arte(String titulo, String artista, String descricao, String imagemCaminho, String categoria)`

O construtor inicializa os atributos da classe `Arte`.

- **Parâmetros**:
  - `titulo`: O título da obra de arte.
  - `artista`: O nome do artista responsável pela obra.
  - `descricao`: A descrição da obra.
  - `imagemCaminho`: O caminho da imagem representando a obra.
  - `categoria`: A categoria da obra (exemplo: Gótica, Nouveau).

### Exemplo de uso:

```java
Arte arteExemplo = new Arte("O Beijo", "Gustav Klimt", "Obra famosa de arte moderna.", "/imagens/o-beijo.jpg", "Art Nouveau");
```

## Métodos

### `public String getTitulo()`

Retorna o título da obra de arte.

**Retorno**: `String` - O título da obra.

### `public String getArtista()`

Retorna o nome do artista responsável pela obra.

**Retorno**: `String` - O nome do artista.

### `public String getDescricao()`

Retorna a descrição da obra de arte.

**Retorno**: `String` - A descrição da obra.

### `public String getImagemCaminho()`

Retorna o caminho da imagem que representa a obra de arte.

**Retorno**: `String` - O caminho da imagem.

### `public String getCategoria()`

Retorna a categoria da obra de arte.

**Retorno**: `String` - A categoria da obra.

### `public List<String> getComentarios()`

Retorna a lista de comentários feitos sobre a obra.

**Retorno**: `List<String>` - A lista de comentários.

### `public void adicionarComentario(String comentario)`

Adiciona um novo comentário à lista de comentários da obra.

- **Parâmetro**:
  - `comentario`: O texto do comentário a ser adicionado.

### Exemplo de uso:

```java
arteExemplo.adicionarComentario("Uma obra impressionante que captura o espírito da era.");
```

## Código da Classe `Arte`

```java
import java.util.ArrayList; // 📦 Importa a classe ArrayList para uso de listas dinâmicas
import java.util.List; // 📦 Importa a interface List para representar listas

public class Arte { // 🎨 Classe que representa uma arte na galeria
    private String titulo; // 🏷️ Título da obra de arte
    private String artista; // 👩‍🎨 Artista responsável pela obra
    private String descricao; // 📝 Descrição da obra de arte
    private String imagemCaminho; // 🖼️ Caminho da imagem que representa a obra
    private String categoria; // 📚 Categoria da obra (ex: Gótica, Nouveau)
    private List<String> comentarios; // 💬 Lista de comentários feitos sobre a obra

    // 🎨 Construtor que inicializa os atributos da classe Arte
    public Arte(String titulo, String artista, String descricao, String imagemCaminho, String categoria) {
        this.titulo = titulo; // 🏷️ Define o título da obra
        this.artista = artista; // 👩‍🎨 Define o artista da obra
        this.descricao = descricao; // 📝 Define a descrição da obra
        this.imagemCaminho = imagemCaminho; // 🖼️ Define o caminho da imagem
        this.categoria = categoria; // 📚 Define a categoria da obra
        this.comentarios = new ArrayList<>(); // 💬 Inicializa a lista de comentários vazia
    }

    // 🏷️ Método para obter o título da obra
    public String getTitulo() {
        return titulo; // 🏷️ Retorna o título da obra
    }

    // 👩‍🎨 Método para obter o artista da obra
    public String getArtista() {
        return artista; // 👩‍🎨 Retorna o nome do artista
    }

    // 📝 Método para obter a descrição da obra
    public String getDescricao() {
        return descricao; // 📝 Retorna a descrição da obra
    }

    // 🖼️ Método para obter o caminho da imagem da obra
    public String getImagemCaminho() {
        return imagemCaminho; // 🖼️ Retorna o caminho da imagem da obra
    }

    // 📚 Método para obter a categoria da obra
    public String getCategoria() {
        return categoria; // 📚 Retorna a categoria da obra
    }

    // 💬 Método para obter a lista de comentários sobre a obra
    public List<String> getComentarios() {
        return comentarios; // 💬 Retorna a lista de comentários sobre a obra
    }

    // 💬 Método para adicionar um comentário à obra
    public void adicionarComentario(String comentario) {
        this.comentarios.add(comentario); // 💬 Adiciona um novo comentário à lista de comentários
    }
}
```

## Exemplo Completo

```java
// Criação de uma nova arte
Arte novaArte = new Arte("A Noite Estrelada", "Vincent van Gogh", "Uma das pinturas mais famosas do mundo.", "/imagens/noite-estrelada.jpg", "Pós-Impressionismo");

// Adicionando um comentário
novaArte.adicionarComentario("Essa obra é uma das mais reconhecíveis e adoradas mundialmente.");

// Exibindo o título da obra
System.out.println("Título: " + novaArte.getTitulo());
```
