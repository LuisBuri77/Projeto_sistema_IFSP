import MESSAGES from "../../config/Mensagens"

export const getMessageByStatus = (status) => {

    switch (status) {
        case 200:
            return MESSAGES.HTTP_STATUS_OK;
        case 201:
            return MESSAGES.HTTP_STATUS_CREATED;
        case 204:
            return MESSAGES.HTTP_NO_CONTENT;
        case 400:
            return MESSAGES.HTTP_STATUS_BAD_REQUEST;
        case 401:
            return MESSAGES.HTTP_STATUS_UNAUTHORIZED;
        case 404:
            return MESSAGES.HTTP_STATUS_NOT_FOUND;
        case 406:
            return MESSAGES.HTTP_STATUS_NOT_ACCEPTABLE;
        case 412:
            return MESSAGES.HTTP_STATUS_PRECONDITION_FAILED;
        case 500:
            return MESSAGES.HTTP_STATUS_INTERNAL_SERVER_ERROR
        case 201:
            return MESSAGES.HTTP_STATUS_CREATED;
        default:
            return MESSAGES.ERR_UNKNOWN;
    }

};

export const getMessageByType = (error) => {

    if (!error.response) {
        return MESSAGES.ERR_NETWORK;
    }

    switch (error.code) {
        case 'ECONNABORTED':
            return MESSAGES.ERR_TIMEOUT;
        case 'ERR_NETWORK':
            return MESSAGES.ERR_NETWORK;
        case 'ERR_CANCEL':
            return MESSAGES.ERR_CANCEL;
        case 'ERR_UNKNOW':
            return MESSAGES.ERR_UNKNOWN;
        case 'ERR_BAD_REQUEST':
            return MESSAGES.ERR_BAD_REQUEST;
        case 'ERR_UNAUTHORIZED':
            return MESSAGES.ERR_UNAUTHORIZED;
        case 'ERR_NOT_FOUND':
            return MESSAGES.ERR_NOT_FOUND;
        case 'ERR_SERVER_ERROR':
            return MESSAGES.ERR_SERVER_ERROR;
        default:
            return getMessageByStatus(error.response.status);
    }

}


