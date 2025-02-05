import { useContext } from "react";
import { AlertContexto } from "../contexto/AlertContexto"

const useAlert = () => {
const contexto = useContext(AlertContexto)
    return contexto;
}
export default useAlert;