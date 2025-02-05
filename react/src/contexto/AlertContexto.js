import { createContext, useCallback, useState } from "react";
import { SUCCESS } from "../config/Config";
import TimeAlert from "../components/mensagem/TimeAlert";

export const AlertContexto = createContext(null);

export const AlertProveder = ({ children }) => {

    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState(null);
    const [variant, setVariant] = useState();
    const [show, setShow] = useState();
    const [duration, setDuration] = useState();

    const clearMeddage = () => {
        setMessage(null);
        setVariant(null);
        setDuration(null);
    }

    const handleShowAlert = () => {
        setShow(false);

    }

    const showAlert = useCallback((msg, type = SUCCESS, dur = 2000) => {
        clearMeddage();
        setMessage(msg);
        setVariant(type);
        setDuration(dur);
        setShow(true);

    }, []);

    return (
        <AlertContexto.Provider value={{
            loading,
            message,
            variant,
            show,
            duration,
            setLoading,
            handleShowAlert,
            showAlert,

        }}>
            {children}
            <TimeAlert />
        </AlertContexto.Provider>

    )

}
