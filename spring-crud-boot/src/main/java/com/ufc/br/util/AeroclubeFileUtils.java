package com.ufc.br.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

public class AeroclubeFileUtils {



        public static void salvarImagem(String caminho, MultipartFile imagem) {
            File file = new File(caminho);

            try {
                FileUtils.writeByteArrayToFile(file, imagem.getBytes());
            }catch(IOException e) {
                e.printStackTrace();
            }

        }

}
