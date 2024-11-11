import java.util.ArrayList; // 📦 Importa a classe ArrayList para uso de listas dinâmicas
import java.util.List; // 📦 Importa a interface List para representar listas
import java.io.Serializable;

public class Arte implements Serializable { // 🎨 Classe que representa uma arte na galeria
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
    if (comentario != null && !comentario.trim().isEmpty()) {
      this.comentarios.add(comentario); // 💬 Adiciona o comentário à lista
    } else {
      System.out.println("Comentário inválido!"); // ⚠️ Exibe mensagem caso o comentário seja inválido
    }
  }

  // 💬 Método para remover um comentário da obra
  public void removerComentario(int indice) {
    if (indice >= 0 && indice < comentarios.size()) {
      comentarios.remove(indice); // 🗑️ Remove o comentário pelo índice
    } else {
      System.out.println("Índice inválido!"); // ⚠️ Exibe mensagem caso o índice seja inválido
    }
  }

  @Override
  public String toString() {
    return titulo; // 🏷️ Retorna o título da arte
  }
}
