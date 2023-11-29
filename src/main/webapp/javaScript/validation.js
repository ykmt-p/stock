// 品名が入力されているか確認する

window.onload = function() {
    var form = document.getElementById('listForm');
    var productNameInput = form.elements['product_name'];
    var submitButton = form.querySelector('input[type="submit"]');

    function checkInputs() {
        var productName = productNameInput.value.trim();
        submitButton.disabled = !(productName);
    }

    productNameInput.addEventListener('input', checkInputs);
    // 初期状態のチェック
    checkInputs();
};
