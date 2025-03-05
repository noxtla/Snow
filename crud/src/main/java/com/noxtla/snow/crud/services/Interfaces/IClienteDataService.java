package com.noxtla.snow.crud.services.Interfaces;

import com.noxtla.snow.crud.models.ClientData;
import java.util.List;
import java.util.Optional;

public interface IClienteDataService {

    /**
     * Guarda un nuevo registro de ClientData.
     *
     * @param clientData El objeto ClientData a guardar.
     * @return El objeto ClientData guardado.
     */
    ClientData save(ClientData clientData);

    /**
     * Actualiza un registro existente de ClientData.
     *
     * @param id         El ID del registro a actualizar.
     * @param clientData El objeto ClientData con los nuevos datos.
     * @return Un Optional que contiene el objeto ClientData actualizado, si existe.
     */
    Optional<ClientData> update(Long id, ClientData clientData);

    /**
     * Obtiene todos los registros de ClientData.
     *
     * @return Una lista de todos los objetos ClientData.
     */
    List<ClientData> findAll();

    /**
     * Busca un registro de ClientData por su ID.
     *
     * @param id El ID del registro a buscar.
     * @return Un Optional que contiene el objeto ClientData, si existe.
     */
    Optional<ClientData> findById(Long id);

    /**
     * Elimina un registro de ClientData por su ID.
     *
     * @param id El ID del registro a eliminar.
     * @return Un Optional que contiene el objeto ClientData eliminado, si existe.
     */
    Optional<ClientData> delete(Long id);
}