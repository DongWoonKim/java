let setupAjax = () => {
    $.ajaxSetup({
        beforeSend: (xhr) => {
            let token = localStorage.getItem("accessToken");
            if (token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
        }
    });
}

let handleTokenExpiration = () => {
    $.ajax({
        type: 'POST',
        url: '/refresh-token',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        xhrFields: {
            withCredentials: true // 쿠키를 포함해서 요청을 보냄
        },
        success: (response) => {
            localStorage.setItem('accessToken', response.accessToken);
        },
        error: (error) => {
            alert('로그인이 필요합니다. 다시 로그인해주세요.');
            window.location.href = '/member/login';
        }
    });
}


let checkToken = () => {
    let token = localStorage.getItem("accessToken");
    if (token == null || token.trim() === '') {
        window.location.href = '/member/login';
    }
}

let getUserInfo = () => {
    return new Promise( (resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: '/user/info',
            success: (response) => {
                resolve(response);
            },
            error: (xhr) => {

            }
        });
    });
}
