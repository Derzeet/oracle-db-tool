import * as React from "react";
import axios from 'axios';



import exportFromJSON from "export-from-json";
import IconButton from '@mui/material/IconButton';
import FileDownloadIcon from '@mui/icons-material/FileDownload';

import './oracleTable.scss'
import LinearProgress from '@mui/material/LinearProgress';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormHelperText from '@mui/material/FormHelperText';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Chip from '@mui/material/Chip';
import OutlinedInput from '@mui/material/OutlinedInput';

const baseURL = "http://192.168.30.24:9091/api/finpol/main"

const dictionaryOfTable = {
    "messOfmId" : "Идентификатор записи о сообщении",
    "messNumber" : "Внутренний для СФМ номер сообщения",
    "messDate" : "Дата сообщения",
    "messType" : "Вид документа",
    "operStatus" : "Состояние операции",
    "messReason" : "Основание для подачи сообщения",
    "cfmCode" : "Код субъекта финансового мониторинга",
    "cfmName" : "Наименование субъекта",
    "cfmMainCode" : "ИИН\БИН",
    "cfmSeatArea" : "Адрес местонахождения - Область",
    "cfmSeatRegion" : "Адрес местонахождения - Регион",
    "cfmSeatCity" : "Адрес местонахождения - Город",
    "cfmSeatStreet" : "Адрес местонахождения - Улица",
    "cfmSeatHouse" : "Адрес местонахождения - Дом",
    "cfmSeatOffice" : "Адрес местонахождения - Офис",
    "cfmSeatPostcode" : "Адрес местонахождения - Почтовый индекс",
    "cfmIsac" : "Физлицо или Юрлицо",
    "docType" : "Тип документа (для физ лиц)",
    "cfmDocNumber" : "Номер док",
    "cfmDocSeries" : "Серия док",
    "cfmDocWhom" : "Кем выдан",
    "cfmDocDate" : "Дата выдачи",
    "operNumber" : "Номер операции",
    "operType" : "Тип операции",
    "operPaymentPurpose" : "Назначение платежа",
    "operMembersCount" : "Колво участников",
    "currencyType" : "Вид валюты",
    "operCurrencyAmount" : "Сумма валютой",
    "operTengeAmount" : "Сумма в тенге",
    "operReason" : "Основание совершения операции",
    "operDocDate" : "Дата документа на основании которого проведена операция",
    "operDocNumber" : "Номер документа операции",
    "suspFirst" : "1 признак подозрительности",
    "suspSecond" : "2 признак подозрительности",
    "suspThird" : "3 признак подозрительности",
    "operDopInfo" : "Доп инфо по операции",
    "memberId" : "Идентификатор участника",
    "memberVid" : "Вид участника",
    "memberResidence" : "Резиденство (1-да, 0-нет)",
    "memberResidenceCountrycode" : "Код страны резиденства",
    "memberType" : "Тип участника",
    "memberForeign" : "Показатель иностранного публичного лица и аффилированных с ним лиц",
    "memberBankCode" : "Код банка участника",
    "memberBankName" : "Название банка",
    "memberBankAccount" : "Счет участника",
    "memberBankAddress" : "Адрес банка",
    "memberUrName" : "Имя участника (Юр лицо)",
    "memberUrFistHeadName" : "Фио первого руководителя (Юр лицо)",
    "memberOked" : "ОКЭД",
    "memberMaincode" : "ИИН\БИН",
    "memberAcFirstName" : "Имя (Физ лицо либо ип)",
    "memberAcSecondName" : "Фамилия",
    "memberAcMiddlename" : "Отчество",
    "memberAcDocType" : "Тип документа участника",
    "memberAcDocSeries" : "Серия",
    "memberAcDocWhom" : "Кем выдан",
    "memberAcDocDate" : "Дата выдачи",
    "memberAcBirthDate" : "Дата рождения",
    "memberAcBirthPlace" : "Место рождения",
    "memberRegArea" : "Область прописки",
    "memberRegRegion" : "Регион прописки",
    "memberRegSity" : "Город",
    "memberRegStreet" : "Улица",
    "memberRegHouse" : "Дом",
    "memberRegOffice" : "Офис",
    "memberPhone" : "Телефон",
    "memberEmail" : "Эмайл",
    "memberSeatArea" : "Фактический адрес проживания - Область",
    "memberSeatRegion" : "Регион",
    "memberSeatSity" : "Город",
    "memberSeatStreet" : "Улица",
    "memberSeatHouse" : "Дом",
    "memberSeatOffice" : "Офис"
}


const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};


const names = {
    'Первый': 'first',
    'Второй': 'second',
    'Третий': 'third',
    'Четвертый': 'fourth',
    'Пятый': 'fifth',
    'Шестой': 'sixth'
}
  

function getStyles(name, personName, theme) {
    return {
      fontWeight:
        personName.indexOf(name) === -1
          ? theme.typography.fontWeightRegular
          : theme.typography.fontWeightMedium,
    };
}

function OracleTable(props) {
    const theme = useTheme();
    const [loading, setLoading] = React.useState(false)
    const labelStyle = {
        fontSize: '14px', /* set the desired font size */
    };
    const [option, setOption] = React.useState('');
    const [filterValues, setFilterValues] = React.useState([]);

    const nameArray = Object.entries(names);
    const handleChange = (event) => {
        setOption(event.target.value);
    };

    const getData = () => {
        setLoading(true)
        const request = axios.CancelToken.source()
        // axios.get('', {
            //     cancelToken: request.token
            // }).then({
                //     //blabla
        // })


        return () => {
            // request.cancel()
            console.log('asd')
            setLoading(false)
        }
    }

    const handleChangeList = (event) => {
        const {
          target: { value },
        } = event;
        setFilterValues(
          // On autofill we get a stringified value.
          typeof value === 'string' ? value.split(',') : value,
        );
    };

    const beforeTableEncode = (data) => {
        const modifiedData = data.map((item) => {
            const modifiedItem = {};
            for (const [key, value] of Object.entries(item)) {
              const newKey = dictionaryOfTable[item[key]] || item[key]; // Use the key from the dictionary or the original key if not found
              modifiedItem[key] = newKey;
            }
            return modifiedItem;
          });
          return modifiedData;
      };
    

    const download = () => {
        const data = [
            {
                messOfmId: "Temirlan", 
                messNumber: "Yessenuly", 
                operDopInfo: 19
            },
            {
                messOfmId: "Damir", 
                messNumber: "Begenov", 
                operDopInfo: 19
            },
            {
                messOfmId: "Maku", 
                messNumber: "Kuanyshbekov", 
                operDopInfo: 133
            },
            {
                messOfmId: "Asanali", 
                messNumber: "Ospan", 
                operDopInfo: 1123},
            {
                messOfmId: "Yernar", 
                messNumber: "Bolat", 
                operDopInfo: 112
            },
        ];
        const fileName = "set"
        const exportType = exportFromJSON.types.csv
        exportFromJSON({data, fileName, beforeTableEncode, exportType})
    }
    return (
        <div className="wholeBlock">
            <div className="searchBar">
                <FormControl sx={{ m: 1, minWidth: 120, width: '90%' }}>
                    <InputLabel id="demo-simple-select-helper-label">Опция</InputLabel>
                    <Select
                        labelId="demo-simple-select-helper-label"
                        id="demo-simple-select-helper"
                        value={option}
                        label="Опция"
                        onChange={handleChange}
                        // size='small'
                        SelectProps={{ style: { backgroundColor: '#fff' } }}
                    >
                        <MenuItem value={'none'}></MenuItem>
                        <MenuItem value={'iin'}>ИИН</MenuItem>
                        <MenuItem value={'bin'}>БИН</MenuItem>
                    </Select>
                    <FormHelperText>Выберите опцию</FormHelperText>
                </FormControl>
                {option === 'iin' && (
                    <>
                        <TextField sx={{width: '90%', p: 0}} style={{ margin: '0 auto', marginBottom: '15px'}} InputLabelProps={{style: labelStyle}} id="outlined-basic" label="ИИН" variant="outlined" />
                        <TextField sx={{width: '90%', p: 0}} style={{ margin: '0 auto', marginBottom: '15px'}} InputLabelProps={{style: labelStyle}} id="outlined-basic" label="ID" variant="outlined" />
                        <FormControl sx={{ m: 1, width: '90%' }} style={{ margin: '0 auto', marginBottom: '15px'}}>
                            <InputLabel id="demo-multiple-chip-label">Фильтр</InputLabel>
                            <Select
                                labelId="demo-multiple-chip-label"
                                id="demo-multiple-chip"
                                multiple
                                value={filterValues}
                                onChange={handleChangeList}
                                input={<OutlinedInput id="select-multiple-chip" label="Фильтр" />}
                                renderValue={(selected) => (
                                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                                        {selected.map((value) => (
                                            <Chip key={value} sx={{borderRadius: '3px'}} label={value} />
                                        ))}
                                    </Box>
                                )}
                                MenuProps={MenuProps}
                                >
                                {nameArray.map(([name, value]) => (
                                    <MenuItem
                                        key={value}
                                        value={name}
                                        style={getStyles(name, filterValues, theme)}
                                    >
                                    {name}
                                    </MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                        <div style={{ marginTop: '100px', display: 'flex', justifyContent: 'flex-end', width: '90%'}}>
                            <Button
                                sx={{
                                height: '34px',
                                backgroundColor: "#33B6FF",
                                color: 'white',
                                width: '100px',
                                }}
                                variant="contained"
                                onClick={getData}
                            >
                                {!loading && (
                                    <span style={{ fontWeight: '600' }} className='buttonSearch'>Запрос</span>
                                )}
                                {loading && (
                                    <span style={{ fontWeight: '600' }} className='buttonSearch'>Отмена</span>
                                )}
                            </Button>
                        </div>
                    </>
                )}
                {option === 'bin' && (
                    <>
                        <TextField size='small' sx={{width: '90%', p: 0}} style={{ margin: '0 auto', marginBottom: '15px'}} InputLabelProps={{style: labelStyle}} id="outlined-basic" label="БИН" variant="outlined" />
                        <TextField size='small' sx={{width: '90%', p: 0}} style={{ margin: '0 auto', marginBottom: '15px'}} InputLabelProps={{style: labelStyle}} id="outlined-basic" label="ID" variant="outlined" />
                    </>
                )}
            </div>
            <div className="tableBlock">
                <div className="tableSam">
                    {loading && (
                        <Box sx={{ width: '100%' }}>
                        <LinearProgress />
                        </Box>
                    )}
                    {!loading && (
                        <ResultTable/>
                    )}
                </div>
                {!loading && (
                    <div style={{ marginTop: '100px', display: 'flex', justifyContent: 'flex-end', width: '95%'}}>
                        <IconButton onClick={download} aria-label="download" size="large">
                            <FileDownloadIcon fontSize="inherit" />
                        </IconButton>
                    </div>
                )}
            </div>
        </div>
    )
}


function ResultTable(props) {
    
    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
            <TableHead>
                <TableRow>
                {Object.values(dictionaryOfTable).map((column) => (
                    <TableCell sx={{ whiteSpace: 'nowrap' }} key={column}>{column}</TableCell>
                    ))}
                </TableRow>
            </TableHead>
            <TableBody>
                {/* {rows.map((row) => (
                    <TableRow
                    key={row.name}
                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                    <TableCell component="th" scope="row">
                    {row.name}
                    </TableCell>
                    <TableCell align="right">{row.calories}</TableCell>
                    <TableCell align="right">{row.fat}</TableCell>
                    <TableCell align="right">{row.carbs}</TableCell>
                    <TableCell align="right">{row.protein}</TableCell>
                </TableRow>
                ))} */}
            </TableBody>
            </Table>
        </TableContainer>
    )
}

export default OracleTable
