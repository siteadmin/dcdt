package gov.hhs.onc.dcdt.convert.impl;

import gov.hhs.onc.dcdt.convert.Converts;
import gov.hhs.onc.dcdt.convert.Converts.List;
import gov.hhs.onc.dcdt.io.utils.ToolFileUtils;
import java.io.File;
import java.nio.file.Path;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("pathConverter")
@List({ @Converts(from = String.class, to = Path.class), @Converts(from = File.class, to = Path.class) })
@Scope("singleton")
public class PathConverter extends AbstractToolConverter {
    @Override
    protected Object convertInternal(Object source, TypeDescriptor sourceType, TypeDescriptor targetType, ConvertiblePair convertPair) {
        return ToolFileUtils.toPath(source);
    }
}