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

let checkToken = () => {
    let token = localStorage.getItem("accessToken");
    if (token == null || token.trim() === '') {
        window.location.href = '/member/login';
    }
}
