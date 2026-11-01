# Atividade de Programação Orientada a Objetos (POO) — Interfaces em Java

Este repositório contém a resolução completa da atividade sobre **Interfaces e Expressões Lambda em Java**, incluindo as respostas teóricas (Questões 1 e 2) e a documentação das implementações práticas (Questões 3, 4 e 5).

## Questões Teóricas

### 1. Métodos com corpo (`default` e `static`) em Interfaces

**A partir de qual versão do Java foi possível implementar métodos com corpo (`default` ou `static`) nas interfaces?**

Foi possível a partir do **Java 8** (lançado em março de 2014). Posteriormente, o **Java 9** também introduziu suporte a métodos `private` e `private static` dentro de interfaces para auxiliar no reaproveitamento de código interno entre métodos `default`.

**Qual é a utilidade de métodos `default` e `static` dentro de interfaces?**

* **Métodos `default` (Evolução de Interfaces e Retrocompatibilidade):**
  * Permitem adicionar novos métodos a interfaces já existentes fornecendo uma implementação padrão, **sem quebrar as classes que já implementam essa interface** (evitando a necessidade de alterar dezenas ou centenas de classes legadas).
  * Um exemplo clássico na própria biblioteca padrão do Java foi a adição do método `forEach()` na interface `Iterable` e `stream()` na interface `Collection` no Java 8, permitindo que todas as coleções antigas passassem a suportar Streams e Lambdas imediatamente.
  * São herdados pelas classes implementadoras e **podem ser sobrescritos (`@Override`)** caso uma classe específica precise de um comportamento diferente do padrão.
* **Métodos `static` (Métodos Utilitários e Fábricas Coesas):**
  * Pertencem diretamente à própria interface (sendo chamados via `NomeDaInterface.metodo()`) e **não podem ser sobrescritos** pelas classes que a implementam.
  * Servem para agrupar métodos utilitários, validações ou métodos de fábrica (*factory methods*) diretamente relacionados ao domínio da interface, eliminando a necessidade de criar classes utilitárias auxiliares separadas (como o antigo padrão `Collections` para `Collection` ou `Paths` para `Path`). Por exemplo, `Comparator.comparing(...)` e `List.of(...)`.

### 2. Interfaces, Baixo Acoplamento e Manutenibilidade

**Explique como as interfaces ajudam na construção de sistemas desacoplados e de fácil manutenção.**

As interfaces estabelecem um **contrato formal** ("**o que** deve ser feito") sem impor os detalhes de implementação ("**como** será feito"). Isso promove o princípio de design *"Programar voltado para uma interface, e não para uma implementação"* (base do **Princípio da Inversão de Dependência — DIP** do SOLID):

* **Redução do Acoplamento:** O código cliente passa a depender apenas da abstração (interface), desconhecendo qual classe concreta está sendo executada por trás.
* **Facilidade de Manutenção e Extensibilidade (Princípio Aberto-Fechado — OCP):** Novas implementações podem ser criadas e plugadas no sistema sem modificar uma única linha do código cliente que consome a interface.
* **Testabilidade (Uso de Mocks/Stubs):** Em testes automatizados (como testes unitários com JUnit), é possível substituir facilmente uma implementação real (que acessa banco de dados ou API externa) por uma implementação falsa (*Mock* ou *InMemory*) que assina a mesma interface.

**Exemplo prático no desenvolvimento de software:**

Imagine o módulo de **Checkout de um E-commerce** que precisa processar pagamentos.
* **Cenário com alto acoplamento (uso direto de classe concreta):** Se a classe `PedidoService` instanciar e chamar diretamente a classe concreta `PagamentoCartaoStripe`, sempre que a empresa decidir adicionar suporte a **Pix**, **Boleto** ou trocar o gateway para **MercadoPago**, será necessário alterar o código interno de `PedidoService` (adicionando vários blocos `if/else` e correndo o risco de introduzir bugs em fluxos que já funcionavam).
* **Cenário desacoplado (uso de Interface):** Cria-se a interface `ProcessadorPagamento` com o método `boolean processar(double valor)`. As classes `PagamentoPix`, `PagamentoCartao` e `PagamentoBoleto` implementam `ProcessadorPagamento`. A classe `PedidoService` recebe apenas uma referência do tipo `ProcessadorPagamento` (via injeção de dependência). Assim, para adicionar um novo meio de pagamento no futuro, basta criar uma nova classe que implemente `ProcessadorPagamento`, mantendo `PedidoService` intacta.

## Questões Práticas (Código-Fonte)

Os códigos das questões práticas foram estruturados nos arquivos `.java` acompanhantes:

| Questão | Arquivo Principal | Conceitos Aplicados |
| :--- | :--- | :--- |
| **Questão 3** | `Questao3.java` | Implementação de múltiplas interfaces (`AparelhoTelefonico`, `NavegadorInternet`, `ReprodutorMusical`) pela classe `Smartphone`. |
| **Questão 4** | `Questao4.java` | Interface funcional (`@FunctionalInterface`) `OperacaoMatematica` e implementação das 4 operações aritméticas com **Expressões Lambda**. |
| **Questão 5** | `Questao5.java` | Segregação de interfaces (`Imprimivel`, `EnviavelPorEmail`) nas classes `RelatorioFinanceiro` e `Contrato`, demonstrando tanto a abordagem com `instanceof` (Pattern Matching) quanto um **design orientado a polimorfismo puro** sem verificações explícitas de tipo. |

### Como compilar e executar

No terminal, dentro do diretório onde estão os arquivos `.java`, execute:

```bash
# Questão 3 - Smartphone (Múltiplas Interfaces)
javac Questao3.java && java Questao3

# Questão 4 - Operações Matemáticas com Expressões Lambda
javac Questao4.java && java Questao4

# Questão 5 - Processamento de Documentos (Polimorfismo e Segregação de Interfaces)
javac Questao5.java && java Questao5
```
