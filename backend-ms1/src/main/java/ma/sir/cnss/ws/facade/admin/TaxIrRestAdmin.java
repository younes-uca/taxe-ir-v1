package  ma.sir.cnss.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.cnss.bean.core.TaxIr;
import ma.sir.cnss.bean.history.TaxIrHistory;
import ma.sir.cnss.dao.criteria.core.TaxIrCriteria;
import ma.sir.cnss.dao.criteria.history.TaxIrHistoryCriteria;
import ma.sir.cnss.service.facade.admin.TaxIrAdminService;
import ma.sir.cnss.ws.converter.TaxIrConverter;
import ma.sir.cnss.ws.dto.TaxIrDto;
import ma.sir.cnss.zynerator.controller.AbstractController;
import ma.sir.cnss.zynerator.dto.AuditEntityDto;
import ma.sir.cnss.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.cnss.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.cnss.zynerator.dto.FileTempDto;

@Api("Manages taxIr services")
@RestController
@RequestMapping("/api/admin/taxIr/")
public class TaxIrRestAdmin  extends AbstractController<TaxIr, TaxIrDto, TaxIrHistory, TaxIrCriteria, TaxIrHistoryCriteria, TaxIrAdminService, TaxIrConverter> {



    @ApiOperation("upload one taxIr")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple taxIrs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all taxIrs")
    @GetMapping("")
    public ResponseEntity<List<TaxIrDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a taxIr by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TaxIrDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  taxIr")
    @PostMapping("")
    public ResponseEntity<TaxIrDto> save(@RequestBody TaxIrDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  taxIr")
    @PutMapping("")
    public ResponseEntity<TaxIrDto> update(@RequestBody TaxIrDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of taxIr")
    @PostMapping("multiple")
    public ResponseEntity<List<TaxIrDto>> delete(@RequestBody List<TaxIrDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified taxIr")
    @DeleteMapping("")
    public ResponseEntity<TaxIrDto> delete(@RequestBody TaxIrDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified taxIr")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple taxIrs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<TaxIr> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("Finds a taxIr and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TaxIrDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds taxIrs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TaxIrDto>> findByCriteria(@RequestBody TaxIrCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated taxIrs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TaxIrCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports taxIrs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TaxIrCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets taxIr data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TaxIrCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets taxIr history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets taxIr paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TaxIrHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports taxIr history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TaxIrHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets taxIr history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TaxIrHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TaxIrRestAdmin (TaxIrAdminService service, TaxIrConverter converter) {
        super(service, converter);
    }


}