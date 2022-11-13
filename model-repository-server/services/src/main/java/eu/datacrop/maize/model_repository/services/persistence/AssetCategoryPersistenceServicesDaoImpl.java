package eu.datacrop.maize.model_repository.services.persistence;

import eu.datacrop.maize.model_repository.commons.dtos.requests.entities.AssetCategoryRequestDto;
import eu.datacrop.maize.model_repository.commons.wrappers.collection.AssetCategoryResponsesWrapper;
import eu.datacrop.maize.model_repository.commons.wrappers.single.entities.AssetCategoryResponseWrapper;
import eu.datacrop.maize.model_repository.persistence.daos.AssetCategoryPersistenceLayerDaos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**********************************************************************************************************************
 * This class redirects enquires to the persistence layer pertaining to AssetCategories.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.4.0
 *********************************************************************************************************************/
@Slf4j
@Service
public class AssetCategoryPersistenceServicesDaoImpl implements AssetCategoryPersistenceServicesDao {

    @Autowired
    AssetCategoryPersistenceLayerDaos persistenceLayer;

    /******************************************************************************************************************
     * Method to retrieve an existing Asset Category using its databaseID as unique identifier.
     *
     * @param databaseID A UUID that uniquely identifies an existing AssetCategory in the database, not null.
     * @return A wrapped data transfer object with either information on the retrieved AssetCategory or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper retrieveAssetCategoryByDatabaseID(String databaseID) {
        log.info("Services layer received request for retrieval of Asset Category with ID: '{}'.", databaseID);
        return persistenceLayer.retrieveAssetCategoryByDatabaseID(databaseID);
    }

    /******************************************************************************************************************
     * Method to retrieve an existing Asset Category using its name as unique identifier.
     *
     * @param name A string that uniquely identifies an existing AssetCategory in the database, not null.
     * @return A wrapped data transfer object with either information on the retrieved AssetCategory or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper retrieveAssetCategoryByName(String name) {
        log.info("Services layer received request for retrieval of Asset Category with Name: '{}'.", name);
        return persistenceLayer.retrieveAssetCategoryByName(name);
    }

    /******************************************************************************************************************
     * Method to retrieve all Asset Categories paginated.
     *
     * @param page The page to retrieve.
     * @param size The intended size of pages.
     * @return A wrapped data transfer object with either information on the retrieved AssetCategories or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponsesWrapper retrieveAllAssetCategories(int page, int size) {
        log.info("Services layer received request for retrieval of all Asset Categories.");
        return persistenceLayer.retrieveAllAssetCategories(page, size);
    }

    /******************************************************************************************************************
     * Method to persist a new Asset Category.
     *
     * @param requestDto A data transfer object with values for the attributes of the AssetCategory, not null.
     * @return A wrapped data transfer object with either information on the created AssetCategory or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper createAssetCategory(AssetCategoryRequestDto requestDto) {
        log.info("Services layer received request for creation of new Asset Category.");
        return persistenceLayer.createAssetCategory(requestDto);
    }

    /******************************************************************************************************************
     * Method to update an existing Asset Category using its databaseID as unique identifier.
     *
     * @param requestDto A data transfer object with values for the attributes of the AssetCategory, not null.
     * @param databaseID A UUID that uniquely identifies an existing AssetCategory in the database, not null.
     * @return A wrapped data transfer object with either information on the updated AssetCategory or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper updateAssetCategory(AssetCategoryRequestDto requestDto, String databaseID) {
        log.info("Services layer received request for update of Asset Category with ID: '{}'.", databaseID);
        return persistenceLayer.updateAssetCategory(requestDto, databaseID);
    }

    /******************************************************************************************************************
     * Method to delete an existing Asset Category using its databaseID as unique identifier.
     *
     * @param databaseID A UUID that uniquely identifies an existing AssetCategory in the database, not null.
     * @return A wrapped data transfer object with either information on the deleted AssetCategory or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper deleteAssetCategory(String databaseID) {
        log.info("Services layer received request for deletion of Asset Category with ID: '{}'.", databaseID);
        return persistenceLayer.deleteAssetCategory(databaseID);
    }

    /******************************************************************************************************************
     * Method to delete all existing Asset Categories.
     *
     * @return A wrapped data transfer object with either a success message or failure messages.
     *****************************************************************************************************************/
    @Override
    public AssetCategoryResponseWrapper deleteAllAssetCategories() {
        log.info("Services layer received request for deletion of all Asset Categories.");
        return persistenceLayer.deleteAllAssetCategories();
    }
}