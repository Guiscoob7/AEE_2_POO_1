```markdown
# Classe `Galeria` 🎨

A classe `Galeria` representa uma galeria de arte, permitindo o gerenciamento de uma coleção de obras, incluindo a adição, remoção, e a busca por categoria.

## Atributos

- `artes` (List<Arte>) 🖼️: Lista que armazena as obras de arte presentes na galeria.

## Construtor

### `public Galeria()`

Construtor da classe que inicializa a lista de obras de arte e adiciona algumas obras de exemplo.

### Exemplo de uso:

```java
Galeria galeria = new Galeria();
```

## Métodos

### `public void adicionarArte(Arte arte)`

Adiciona uma nova obra de arte à galeria.

- **Parâmetros**:
  - `arte`: A obra de arte a ser adicionada à galeria.

**Validações**:
- Verifica se a obra não é nula.
- Verifica se a obra ainda não está presente na galeria antes de adicioná-la.

**Exemplo de uso**:

```java
galeria.adicionarArte(novaArte);
```

### `public List<Arte> getArtes()`

Retorna a lista completa de obras de arte na galeria.

**Retorno**: `List<Arte>` - A lista de todas as obras de arte na galeria.

### `public List<Arte> getArtesPorCategoria(String categoria)`

Filtra e retorna as obras de uma categoria específica.

- **Parâmetro**:
  - `categoria`: O nome da categoria a ser filtrada.

**Retorno**: `List<Arte>` - Lista das obras que pertencem à categoria especificada.

**Exemplo de uso**:

```java
List<Arte> artesGotic = galeria.getArtesPorCategoria("Gótica");
```

### `public void removerArte(Arte arte)`

Remove uma obra específica da galeria.

- **Parâmetro**:
  - `arte`: A obra de arte a ser removida.

**Validações**:
- Verifica se a obra existe na galeria antes de tentar removê-la.

**Exemplo de uso**:

```java
galeria.removerArte(arteAExcluir);
```

### `private void inicializarArtes()`

Método privado que inicializa a galeria com algumas obras de arte de exemplo.

Este método é chamado automaticamente no construtor para adicionar obras de exemplo à galeria.

## Código da Classe `Galeria`

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Galeria {
    // 🎨 Lista para armazenar todas as obras de arte na galeria
    private List<Arte> artes;

    // 🖼️ Construtor da galeria que inicializa a lista de artes e adiciona exemplos
    public Galeria() {
        this.artes = new ArrayList<>();  // 🎨 Inicializa a lista vazia
        inicializarArtes();              // 🌱 Adiciona algumas obras de exemplo
    }

    // ➕ Adiciona uma nova obra de arte à galeria
    public void adicionarArte(Arte arte) {
        // ✅ Verifica se a obra não é nula e não está na lista antes de adicionar
        if (arte != null && !artes.contains(arte)) {
            artes.add(arte);
        } else {
            // ⚠️ Exibe uma mensagem caso a obra seja inválida ou já exista
            System.out.println("Arte inválida ou já existente.");
        }
    }

    // 📜 Retorna a lista completa de obras de arte na galeria
    public List<Arte> getArtes() {
        return artes;
    }

    // 🎯 Filtra e retorna as obras de uma categoria específica
    public List<Arte> getArtesPorCategoria(String categoria) {
        // 🔍 Usa um filtro para encontrar as obras que correspondem à categoria
        return artes.stream()
            .filter(arte -> arte.getCategoria().equalsIgnoreCase(categoria))
            .collect(Collectors.toList());
    }

    // ❌ Remove uma obra específica da galeria
    public void removerArte(Arte arte) {
        // ✅ Verifica se a obra existe na galeria antes de tentar removê-la
        if (arte != null && artes.contains(arte)) {
            artes.remove(arte);
        } else {
            // ⚠️ Exibe uma mensagem caso a obra não seja encontrada
            System.out.println("Arte não encontrada.");
        }
    }

    // 🌱 Inicializa a galeria com algumas obras de arte de exemplo
    private void inicializarArtes() {
        // 🖼️ Adiciona artes com título, artista, descrição, caminho de imagem e categoria
        adicionarArte(new Arte("A Obra Gótica", "Artista Gótico", "Descrição gótica", "src/main/java/recursos/gotico_imagens/acapa-1.png", "Gótica"));
        adicionarArte(new Arte("Obra Nouveau", "Artista Nouveau", "Descrição Nouveau", "src/main/java/recursos/nouveau_imagens/artnouveau-capa.png", "Nouveau"));
        adicionarArte(new Arte("Outra Obra Nouveau", "Artista Marie", "Vívido", "src/main/java/recursos/nouveau_imagens/alphonse-mucha-zodiac-1897.jpeg", "Nouveau"));
    }
}
```

## Exemplo Completo

```java
// Criação de uma galeria
Galeria galeria = new Galeria();

// Adicionando uma nova obra
Arte novaArte = new Arte("Nova Obra", "Novo Artista", "Descrição da nova obra", "/imagens/nova_obra.jpg", "Moderno");
galeria.adicionarArte(novaArte);

// Obtendo todas as obras de uma categoria
List<Arte> obrasNouveau = galeria.getArtesPorCategoria("Nouveau");

// Removendo uma obra
galeria.removerArte(novaArte);
```
