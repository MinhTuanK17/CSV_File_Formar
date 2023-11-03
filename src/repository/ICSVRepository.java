/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.CSV;

/**
 *
 * @author MINH TUAN
 */
public interface ICSVRepository {

    void formarAddress(ArrayList<CSV> al);

    void formatName(ArrayList<CSV> al);

    void ImportFile(ArrayList<CSV> al, String filename);

    void ExportFile(ArrayList<CSV> al, String filename);
}
