// チェックボックスにチェックがされているか調べる

function checkIfAnyCheckboxChecked() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var submitButton = document.querySelector('input[type="submit"]');
    var atLeastOneChecked = false;

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            atLeastOneChecked = true;
            break;
        }
    }

    submitButton.disabled = !atLeastOneChecked;
}
window.onload = function() {
    checkIfAnyCheckboxChecked();
}