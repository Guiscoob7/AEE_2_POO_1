```markdown
# Documentação da Classe Principal `Main`

A classe `Main` é a classe de entrada do aplicativo, responsável por inicializar e exibir a janela principal da aplicação. Abaixo, está a explicação detalhada do código.

---

## Pacotes Importados

```java
import javax.swing.SwingUtilities; // 📦 Importa a classe SwingUtilities para gerenciamento de threads e UI
```

- **`SwingUtilities`**: Esta classe é usada para garantir que as atualizações na interface gráfica ocorram na thread de evento da UI, o que é essencial em aplicativos Swing para evitar problemas de concorrência.

---

## Classe `Main`

```java
public class Main { // 🖥️ Classe principal do aplicativo
```

- **Classe `Main`**: A classe `Main` contém o método `main`, que é o ponto de entrada da aplicação. Ela é responsável por iniciar a execução do programa e mostrar a janela principal.

### Método `main`

```java
public static void main(String[] args) { // 📋 Método principal que inicia a aplicação
```

- **`main`**: O método `main` é o ponto de entrada da aplicação Java. Quando a aplicação é executada, este método é chamado primeiro.

### `SwingUtilities.invokeLater`

```java
SwingUtilities.invokeLater(() -> { // ⏳ Garante que a criação da janela ocorra na thread de evento da UI
```

- **`SwingUtilities.invokeLater`**: Este método garante que o código dentro de seu bloco seja executado na **thread de eventos da UI** (a thread responsável pela interação com a interface gráfica). Isso é importante para garantir que as alterações na interface gráfica, como a criação de componentes e janelas, ocorram de maneira segura.

### Criação da Janela Principal

```java
JanelaPrincipal janela = new JanelaPrincipal(); // 🖼️ Cria uma instância da janela principal
janela.setVisible(true); // 👀 Torna a janela visível na tela
```

- **`JanelaPrincipal janela = new JanelaPrincipal()`**: Cria uma instância da classe `JanelaPrincipal`, que é a janela principal da aplicação, responsável por exibir o conteúdo gráfico.
- **`janela.setVisible(true)`**: Torna a janela visível na tela, permitindo que o usuário interaja com a interface gráfica.

---

## Conclusão

A classe `Main` é a responsável por inicializar a aplicação, criando e exibindo a janela principal. A utilização do `SwingUtilities.invokeLater` assegura que a criação da interface gráfica aconteça de forma thread-safe, evitando problemas relacionados à concorrência na atualização da UI.

Este código é um exemplo básico de como iniciar uma aplicação Swing em Java, utilizando boas práticas para o gerenciamento de threads ao lidar com a interface gráfica.
```
