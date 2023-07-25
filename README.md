# Calculadora para Precificação de Produtos e de Gastos com Matérias-Primas.

Este repósitorio foi criado com o propósito de auto-aperfeiçoamento no desenvolvimento de projetos em Java.

O projeto é uma API desenvolvida com o objetivo de fornecer uma interface para o cálculo realizado na **precificação de produtos** para posterior venda e para o cálculo de **gastos com as matérias-primas** utilizadas em seus produtos. Futuramente, a ideia é transformar esta API em um WebService, porém, atualmente ela já é capaz de executar em qualquer browser padrão.
#
A função de cálculo dos gastos com matérias-primas está concluída no backend, mas o intuito é fornecer uma interface de frontend que será desenvolvida futuramente. Esta função tem a capacidade de organizar, em um banco de dados, as matérias-primas adicionadas pelo usuário.

São necessários o nome, o preço pago na matéria-prima, o peso usado da matéria-prima na sua formulação e o peso total comprado de matéria-prima. Com estas informações, será feito o cálculo equivalente ao gasto desta matéria-prima usada em cada produto e retornado ao usuário, enquanto também é armazenada em seu banco de dados exclusivo.

O software fornece as principais operações de Criação, Leitura, Atualização e Exclusão (CRUD) no banco de dados para cada matéria-prima.
#
A função de cálculo final para a precificação de um produto ainda não está concluída, mas já está em desenvolvimento. A ideia é semelhante à função relacionada às matérias-primas. Entretanto, cada produto poderá ter uma lista de matérias-primas que o constituem e a ideia é incluir no preço final os gastos administrativos, o percentual de lucro desejado, além de todos os gastos de produção, para que seja retornado ao usuário o preço final recomendado com base nas necessidades de cada usuário.