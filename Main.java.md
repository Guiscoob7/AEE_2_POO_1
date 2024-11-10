```markdown
# Documentação do Código Principal

Este código é responsável por iniciar a aplicação gráfica. A classe `Main` contém o método `main`, que executa a criação da janela principal da aplicação na thread de eventos do Swing.

## Importações

```java
import javax.swing.SwingUtilities; // 📦 Importa a classe SwingUtilities para gerenciamento de threads e UI
```

A classe `SwingUtilities` é usada para garantir que a interface gráfica seja manipulada na thread apropriada do Swing, evitando problemas de concorrência na atualização da interface.

## Classe Principal - `Main`

A classe `Main` contém o método `main`, que é o ponto de entrada da aplicação. Este método é responsável por iniciar a interface gráfica, criando uma instância da classe `JanelaPrincipal` e tornando-a visível.

### Método `main(String[] args)`

Este método é executado quando o aplicativo é iniciado:
- **`SwingUtilities.invokeLater()`**: Garante que o código dentro do bloco seja executado na thread de eventos do Swing, o que é necessário para a criação e manipulação de componentes gráficos.
- **`JanelaPrincipal janela = new JanelaPrincipal();`**: Cria uma instância da janela principal da aplicação.
- **`janela.setVisible(true);`**: Torna a janela visível para o usuário.

## Exemplo de Uso

1. Ao executar o programa, a classe `Main` inicia a execução do aplicativo.
2. A janela principal da aplicação é criada e exibida ao usuário.

---

## Código

```java
import javax.swing.SwingUtilities; // 📦 Importa a classe SwingUtilities para gerenciamento de threads e UI

public class Main { // 🖥️ Classe principal do aplicativo
    public static void main(String[] args) { // 📋 Método principal que inicia a aplicação
        SwingUtilities.invokeLater(() -> { // ⏳ Garante que a criação da janela ocorra na thread de evento da UI
            JanelaPrincipal janela = new JanelaPrincipal(); // 🖼️ Cria uma instância da janela principal
            janela.setVisible(true); // 👀 Torna a janela visível na tela
        });
    }
}
```
