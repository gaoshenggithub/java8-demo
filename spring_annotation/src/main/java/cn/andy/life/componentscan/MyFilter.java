package cn.andy.life.componentscan;

import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyFilter implements TypeFilter {

    /**
     * @param metadataReader        读取到当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类扫描信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        if (className.contains("BookController")) {
            return true;
        }
        return false;
    }
}
