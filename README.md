# Temperature MapReduce

Projeto Java Maven para calcular a média das temperaturas do arquivo `forestfireinput.csv`
utilizando três classes:

- `Main`: coordena a execução.
- `Map`: lê cada linha e extrai a temperatura.
- `Reduce`: soma as temperaturas e divide pela quantidade de registros.

## Dataset

O arquivo utilizado é o `forestfireinput.csv`, que não possui cabeçalho.

No dataset Forest Fires, a temperatura (`temp`) está na 9ª coluna, índice `8`.

## Fórmula

A média é calculada como:

média = soma de todas as temperaturas / quantidade de temperaturas

Isso evita o erro de calcular uma "média das médias" de grupos com quantidades diferentes de registros.

## Como executar

No terminal, na raiz do projeto:

```bash
mvn clean compile
mvn exec:java
```

Também é possível abrir a pasta como projeto Maven no IntelliJ IDEA e executar a classe:

`br.pucpr.mapreduce.Main`

## Resultado esperado

Com o arquivo fornecido, o programa deve processar 517 temperaturas e apresentar uma média próxima de:

`18.89 °C`
