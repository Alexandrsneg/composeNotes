package ru.alexandrsneg.composenotes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

//@RunWith(MockitoJUnitRunner::class)
//class PutTwoLoadsUnitTest {
//
//    @get: Rule
//    val mainDispatcherRule = MainDispatcherRule()
//
//    @get: Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    lateinit var cargoUseCase: IGetCargoUseCase
//    lateinit var getLocationUseCase: IGetLocationUseCase
//    lateinit var checkInputUseCase: ICheckInputUseCase
//    lateinit var putTwoLoadsUseCase: IPutTwoLoadsUseCase
//    lateinit var timberLogger: ITimberLogger
//
//    lateinit var vm: PutTwoLoadsViewModel
//
//    @Before
//    fun setup() {
//        cargoUseCase = mock()
//        getLocationUseCase = mock()
//        checkInputUseCase = mock()
//        putTwoLoadsUseCase = mock()
//        timberLogger = mock()
//
//        vm = PutTwoLoadsViewModel(
//            cargoUseCase,
//            getLocationUseCase,
//            checkInputUseCase,
//            putTwoLoadsUseCase,
//            timberLogger,
//        )
//    }
//
//    @Test
//    fun `test_success_subscribing_on_data`() = runTest {
//        assertEquals(true, vm.loadingLiveData.value)
//        vm.scenario = PutTwoLoadsScenario(
//            scenario = "put_transit",
//            0,
//            0,
//            "",
//        )
//
//        val expectedCargoName = "firstCargoName"
//        val firstCargoResult: Result<Loads, ErrorResponse> = Result.Success(
//            data = Loads().apply {
//                name = expectedCargoName
//            },
//        )
//
//        val expectedLocationName = "G-01"
//        val locationResult: Result<Location, ErrorResponse> = Result.Success(
//            data = Location().apply {
//                name = expectedLocationName
//            },
//        )
//
//        cargoUseCase.stub {
//            onBlocking { execute(any()) }.thenReturn(firstCargoResult)
//        }
//        getLocationUseCase.stub {
//            onBlocking { execute(any()) }.thenReturn(locationResult)
//        }
//        vm.subscribeOnDataSources()
//
//        assertEquals(expectedCargoName, vm.firstCargoNameLiveData.value)
//        assertEquals(expectedLocationName, vm.locationNameLiveData.value)
//
//        assertEquals(false, vm.loadingLiveData.value)
//    }
//
//    @Test
//    fun `test_error_subscribing_on_data`() = runTest {
//        assertEquals(true, vm.loadingLiveData.value)
//        vm.scenario = PutTwoLoadsScenario(
//            scenario = "put_transit",
//            0,
//            0,
//            "",
//        )
//
//        val cargoErrorMsg = "Cargo error message"
//        val errorCargoResult: Result<Loads, ErrorResponse> = Result.Error(
//            msg = cargoErrorMsg,
//        )
//
//        val locationErrorMessage = "Location invalid"
//        val errorLocationResult: Result<Location, ErrorResponse> = Result.Error(
//            msg = locationErrorMessage,
//        )
//
//        cargoUseCase.stub {
//            onBlocking { execute(any()) }.thenReturn(errorCargoResult)
//        }
//
//        getLocationUseCase.stub {
//            onBlocking { execute(any()) }.thenReturn(errorLocationResult)
//        }
//
//        vm.subscribeOnDataSources()
//
//        assertEquals("null", vm.firstCargoNameLiveData.value)
//
//        vm.singleFailLiveData.value!!.consume {
//            assertEquals(locationErrorMessage, it.reason)
//        }
//        assertEquals(false, vm.loadingLiveData.value)
//    }
//}
