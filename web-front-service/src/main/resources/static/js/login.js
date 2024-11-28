$(document).ready(() => {
    setupAjax();
    loginClicked();
});

let loginClicked = () => {
    $('#login').click(() => {
        let userId = $('#user_id').val();
        let password = $('#password').val();

        let formData = {
            userId : userId,
            password : password
        }

        $.ajax({
            type: 'POST',
            url: '/login', // 서버의 엔드포인트 URL
            data: JSON.stringify(formData), // 데이터를 JSON 형식으로 변환
            contentType: 'application/json; charset=utf-8', // 전송 데이터의 타입
            dataType: 'json', // 서버에서 받을 데이터의 타입
            success: (response) => {
                console.log('login :: ', response);
                alert(response.message);
                localStorage.setItem('accessToken', response.accessToken);
                // 로그인 성공 시 '/' 경로로 이동
                window.location.href = response.url;
            },
            error: (xhr) => {
                if (xhr.status === 401) {
                    // Refresh Token을 통해 Access Token 재발급 요청
                    handleTokenExpiration();
                } else {
                    // 다른 오류 처리
                    console.error('요청 오류 발생:', xhr);
                }
            }

        });
    });
}