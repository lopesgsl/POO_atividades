# Respostas da Lista de Exercícios 04

## Questão 1
**a) Os construtores de superclasse não são herdados por subclasses.**
* **Resposta:** **Verdadeira**. Em Java, construtores não são membros herdáveis. A subclasse pode invocar os construtores da superclasse (usando a palavra-chave `super`), mas não os herda diretamente.

**b) Um relacionamento tem um é implementado via herança.**
* **Resposta:** **Falsa**. O relacionamento "tem um" (*has-a*) é implementado por meio de **composição** ou **agregação** (quando uma classe possui como atributo uma referência para outra classe). A herança implementa o relacionamento "é um" (*is-a*).

**c) Quando uma subclasse redefinir um método de superclasse utilizando a mesma assinatura, diz-se que a subclasse sobrecarrega esse método de superclasse.**
* **Resposta:** **Falsa**. Quando uma subclasse redefine um método com a mesma assinatura (mesmo nome, parâmetros e retorno compatível), ocorre a **sobrescrita** (*override*) de método. A **sobrecarga** (*overload*) ocorre quando métodos compartilham o mesmo nome, mas possuem assinaturas/parâmetros diferentes dentro da mesma classe ou na hierarquia.

---

## Questão 2
**Discussão: Acesso `protected` vs. `private` em superclasses**

* **Acesso `protected`:**
  * **Vantagens:** Permite que as subclasses acessem diretamente atributos e métodos da superclasse, facilitando o reaproveitamento de código e evitando chamadas repetitivas a getters/setters em hierarquias diretas.
  * **Desvantagens:** Enfraquece o encapsulamento. Atributos `protected` ficam expostos não apenas para subclasses, mas para todas as classes pertencentes ao mesmo pacote (*package-private*). Caso a estrutura interna da superclasse mude, todas as subclasses e classes do pacote que acessam esses campos diretamente podem ser impactadas.

* **Acesso `private`:**
  * **Vantagens:** Garante o nível máximo de encapsulamento. A superclasse retém o controle absoluto sobre a validação e modificação de seu estado. Alterações na implementação interna da superclasse não afetam as subclasses, desde que a interface pública dos métodos seja preservada.
  * **Desvantagens:** Exige que a subclasse utilize métodos getters/setters ou métodos de negócio para manipular o estado da superclasse.

**Conclusão/Boa prática:** Recomenda-se manter os **atributos privados** (`private`) e fornecer métodos auxiliares `protected` ou `public` caso as subclasses precisem interagir com o estado da superclasse.

---

## Questão 3
**Funcionamento da chamada de construtores em hierarquias de herança**

Em Java, a instanciação de um objeto em uma hierarquia de herança segue uma ordem estrita do topo (superclasse) até a classe mais derivada (subclasse):

1. **Ordem de Execução:** Quando um objeto da subclasse é instanciado, o construtor da superclasse deve ser executado primeiro para inicializar os membros e a estrutura herdados.
2. **Obrigatoriedade da Chamada:** A chamada é obrigatória para assegurar que a parte herdada do objeto esteja em um estado válido antes que a subclasse execute suas próprias inicializações.
3. **Chamada Implícita vs. Explícita:**
   * **Implícita:** Se o programador não incluir uma chamada a `super(...)` no construtor da subclasse, o compilador insere automaticamente a instrução `super()` (construtor padrão sem argumentos) na primeira linha do construtor.
   * **Explícita:** Se a superclasse não tiver um construtor sem argumentos (por ter apenas construtores parametrizados), o programador **deve** chamar explicitamente `super(argumentos...)` na primeira linha do construtor da subclasse; caso contrário, haverá erro de compilação.
