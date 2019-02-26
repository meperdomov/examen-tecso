package coop.tecso.examen.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import coop.tecso.examen.dto.CuentaCorrienteDto;


@Component
public class CuentaValidator implements Validator {

	@Override
	public boolean supports(Class<?> target) {
		return CuentaCorrienteDto.class.isAssignableFrom(target);
	}

	@Override
	public void validate(Object object, Errors errors) {
//		if (object != null) {
//			AuxiliaryServiceConfigurationDTO dto = (AuxiliaryServiceConfigurationDTO) object;
//			Float restNoProvideService = (float) 0.00;
//			Float sumNoProvideService = (float) 0.00;
//			Float restProvideService = (float) 0.00;
//			Float sumProvideService = (float) 0.00;
//			if (!dto.isProvideService()) {
//				if (dto.getId() != null) {
//					sumNoProvideService = this.auxiliaryServiceConfigService
//							.getTotalPercentNoProvideEquipments(dto.getAuxiliaryServiceDTO().getId(), dto.getId());
//				} else {
//					sumNoProvideService = this.auxiliaryServiceConfigService
//							.getTotalPercentNoProvideEquipments(dto.getAuxiliaryServiceDTO().getId(), null);
//				}
//			} else {
//				if (dto.getId() != null) {
//					sumProvideService = this.auxiliaryServiceConfigService
//							.getTotalPercentProvideEquipments(dto.getAuxiliaryServiceDTO().getId(), dto.getId());
//				} else {
//					sumProvideService = this.auxiliaryServiceConfigService
//							.getTotalPercentProvideEquipments(dto.getAuxiliaryServiceDTO().getId(), null);
//				}
//			}
//			restNoProvideService = (float) (100.00 - sumNoProvideService);
//			restProvideService = (float) (100.00 - sumProvideService);
//
//			Float percent = dto.getPercent();
//			if (percent > restNoProvideService) {
//				errors.rejectValue("percent", "400",
//						"El porcentaje configurado para los equipos que no prestan servicio supera al 100% del servicio auxiliar");
//			}
//
//			if (percent > restProvideService) {
//				errors.rejectValue("percent", "400",
//						"El porcentaje configurado para los equipos que prestan servicio supera al 100% del servicio auxiliar");
//			}
//
//			if (dto.isProvideService()) {
//				Integer countProvide = auxiliaryServiceConfigService.getCountOfProvideEquipments(
//						dto.getAuxiliaryServiceDTO().getId(), dto.getEquipmentDTO().getId());
//				if (countProvide != 0 && dto.getId() == null) {
//					errors.rejectValue("", "400",
//							"El equipo seleccionado ya existe en la configuración del servicio auxiliar que presta servicio");
//				}
//			} else {
//				Integer countNoProvide = auxiliaryServiceConfigService.getCountOfNoProvideEquipments(
//						dto.getAuxiliaryServiceDTO().getId(), dto.getEquipmentDTO().getId());
//
//				if (countNoProvide != 0 && dto.getId() == null) {
//					errors.rejectValue("", "400",
//							"El equipo seleccionado ya existe en la configuración del servicio auxiliar que no presta servicio");
//				}
//			}
//		}
	}
}
