// リストが表示されているか確認する

window.onload = function() {
    var stockList = document.querySelector('#list');
    var isEmpty = stockList.querySelector('img');
    if (isEmpty) {
        stockList.style.border = 'none';
        stockList.style.padding = '0';
    }
};