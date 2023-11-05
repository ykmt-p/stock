// 追加バーをポップアップにする

document.addEventListener("DOMContentLoaded", function () {
    const addButton = document.getElementById("addButton");
    const addPopup = document.getElementById("addPopup");

    addButton.addEventListener("click", function () {
        addPopup.style.display = "block"; // ポップアップを表示
    });

    // 閉じるをクリックしたときにポップアップを非表示に
    closePopupButton.addEventListener("click", function () {
        addPopup.style.display = "none";
    });
});
