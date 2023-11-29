// チェックボックスにチェックがされているか調べる

window.onload = function() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var submitButton = document.querySelector('input[type="submit"]');
    
    function checkIfAnyCheckboxChecked() {
        var atLeastOneChecked = false; // チェックがされているかを判定する変数

        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                atLeastOneChecked = true;
                break; // チェックがされている場合はループを抜ける
            }
        }

        submitButton.disabled = !atLeastOneChecked;
    }

    // ページ読み込み時にチェックボックスの状態を確認
    checkIfAnyCheckboxChecked();

    // すべてのチェックボックスに対して、状態が変わったときに関数を呼び出すイベントリスナーを追加
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', checkIfAnyCheckboxChecked);
    });
}
