package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import co.rivatech.nutrition.constatnts.DateUtil;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.DailyAttendence;
import co.rivatech.nutrition.repository.AttendenceRepository;
import co.rivatech.nutrition.repository.ChildRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepository attendenceRepository;

    @Autowired
    private ChildRepository childRepository;

    public DailyAttendence save(final DailyAttendence dailyAttendence) {
        attendenceRepository.save(dailyAttendence);
        return dailyAttendence;
    }

    public Boolean getTodaysAttendenceStatus() {
        final DailyAttendence dailyAttendence = attendenceRepository.findTopByOrderByIdDesc();
        if (null != dailyAttendence) {
            return DateUtil.getTodaysDate(new Date()).compareTo(DateUtil.getTodaysDate(dailyAttendence.getDate())) == 0;
        }
        return false;
    }

    public List<Child> getStudentData(final int tolaId) {
        final List<Child> children = childRepository.findByTolaId(tolaId);
        if (children.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No student found for tola id %s", tolaId));
        }
        return children;
    }

    public Child getChildById(final int id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(
                        "No child data found with id %s ",
                        id)));
    }

    public List<Child> getChildByName(final String name) {
        return childRepository.findByNameContaining(name);
    }

    public List<Child> getChildByNameHindi(final String nameHindi) {
        return childRepository.findByNameHindiContaining(nameHindi);
    }

    public List<Child> getChildByTolaIdAndChildId(final int tolaId, final int childId) {
        return childRepository.findByTolaIdAndId(tolaId, childId);
    }

    public List<Child> getChildByTolaIdAndNameContaining(final int tolaId, final String name) {
        return childRepository.findByTolaIdAndNameContaining(tolaId, name);
    }

    public List<Child> getChildByTolaIdAndNameContainingHindi(final int tolaId, final String nameHindi) {
        return childRepository.findByTolaIdAndNameHindiContaining(tolaId, nameHindi);
    }
}
