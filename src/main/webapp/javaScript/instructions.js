//index　ー使い方ーの隠れている部分

// ボタン要素を取得
	const toggleButton = document.getElementById('toggleButton');
// コンテンツ要素を取得
	const content = document.getElementById('content')
// ボタンがクリックされたときの処理
	toggleButton.addEventListener('click', function() {
// コンテンツの表示状態を切り替える
    if (content.style.display === 'none' || content.style.display === '') {
        content.style.display = 'block'; // 表示
    } else {
        content.style.display = 'none'; // 非表示
    } });